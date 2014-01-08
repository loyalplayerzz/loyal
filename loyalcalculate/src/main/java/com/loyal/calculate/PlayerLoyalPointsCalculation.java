package com.loyal.calculate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.GameRoundSummaryDAO;
import com.loyal.persistence.dao.LevelDAO;
import com.loyal.persistence.dao.LoyalpointsDAO;
import com.loyal.persistence.dao.PlayersDAO;
import com.loyal.persistence.dao.PlayersLevelDAO;
import com.loyal.persistence.dao.PlayersLoyalpointsDAO;
import com.loyal.persistence.dto.GameRoundSummaryDTO;
import com.loyal.persistence.dto.PlayersDTO;
import com.loyal.persistence.dto.PlayersLevelDTO;
import com.loyal.persistence.dto.PlayersLoyalpointsDTO;



/**
 * 1) Find from configuration table for how many rows you need to run the job. Lets suppose it is 200
2) Find from configuration table from which ID you need to run the job. Lets suppose 400 
3) Run the job for number of rows found in  step 1) and from the the id greater then found in step 2
    so if last time you had run the job till ID 400 then you will in this transaction from ID 401 till next 200 rows.
    lets suppose to you find 175 rows (it can be anything from 0 to 200). Store the last id value in variable
    called lastIDProcessed, lets suppose it is 575 (400+175)

4) For each row find the player id and see if there are more rows for that player if yes then sum the total 
     number of rows found to find total bet. If player already exist then update the his loyalty points with time
    stamp else create new player with loyalty points and time stamp. 
   Alternatively do group by query (on userid) in step 3 for next 200 rows and then run the step 4 for each
   unique user

5) Do Step 4 for each row but remember if player id has already dealt with then we should just ignore the row
    since player can have multiple rows it means that we might find row for player for which we have already done
the calculation, this problem may be avoided by selecting rows with group by on userid and then run the logic
for each unique userid.(described as alternate method in Step 4)
6) Update the configuration table with lastIDProcessed
 *
 *
 * NOTE: Pseudo code for calculation of loyalty points as I understood(all this to be done in 1 transaction). It is important
to remember that this algo cannot be run on multiple servers else it will cause problems.
 *
 */

public class PlayerLoyalPointsCalculation {
	
	@Autowired
	public GameRoundSummaryDAO gameRoundSummaryDAO;
	
	public GameRoundSummaryDAO getGameRoundSummaryDAO() {
		return gameRoundSummaryDAO;
	}

	public void setGameRoundSummaryDAO(GameRoundSummaryDAO gameRoundSummaryDAO) {
		this.gameRoundSummaryDAO = gameRoundSummaryDAO;
	}
	
	@Autowired
	public PlayersDAO playersDAO;

	public PlayersDAO getPlayersDAO() {
		return playersDAO;
	}

	public void setPlayersDAO(PlayersDAO playersDAO) {
		this.playersDAO = playersDAO;
	}
	
	@Autowired
	public PlayersLevelDAO playerLevelDAO;
	
	public PlayersLevelDAO getPlayerLevelDAO() {
		return playerLevelDAO;
	}

	public void setPlayerLevelDAO(PlayersLevelDAO playerLevelDAO) {
		this.playerLevelDAO = playerLevelDAO;
	}

	@Autowired
	public LevelDAO levelDAO;
	
	public LevelDAO getLevelDAO() {
		return levelDAO;
	}

	public void setLevelDAO(LevelDAO levelDAO) {
		this.levelDAO = levelDAO;
	}

	@Autowired
	public PlayersLoyalpointsDAO playerLoyalPointsDAO;

	public PlayersLoyalpointsDAO getPlayerLoyalPointsDAO() {
		return playerLoyalPointsDAO;
	}

	public void setPlayerLoyalPointsDAO(PlayersLoyalpointsDAO playerLoyalPointsDAO) {
		this.playerLoyalPointsDAO = playerLoyalPointsDAO;
	}
	
	@Autowired
	public LoyalpointsDAO loyalPointsDAO;

	public LoyalpointsDAO getLoyalPointsDAO() {
		return loyalPointsDAO;
	}

	public void setLoyalPointsDAO(LoyalpointsDAO loyalPointsDAO) {
		this.loyalPointsDAO = loyalPointsDAO;
	}

	public boolean calculateLoyaltyPoints(){
		boolean success = false;
		int lastID = 0;
		// Retrieve start ID from which Config table needs to 
		int noOfRows = retrieveConfigurationBasedOnParam("noOfRows", "ConfigTableName");
		int startID = retrieveConfigurationBasedOnParam("startID", "ConfigTableName");
		int playerID = 0;
		
		//Map<Integer, Integer> totalBetMap = new HashMap<Integer, Integer>();
		for(int i = startID; i< startID+noOfRows; i++){
			// Get PlayerID for that instance
			
			GameRoundSummaryDTO gameRoundDTO = gameRoundSummaryDAO.findById(startID);
			playerID = Integer.valueOf(gameRoundDTO.getPlayerId());
			
			// Retrieve PlayerID from existing table to variable existingPlayerID
			PlayersDTO playerDTO = playersDAO.findById(playerID);
			int totalBetAmt = 0;
			if(playerDTO != null){
				// update the player with existing betAmt+newbetAmt
				totalBetAmt = playerDTO.getBetAmt()+gameRoundDTO.getTotalBet().intValue();
			} else {
				totalBetAmt = gameRoundDTO.getTotalBet().intValue();
			}
			playerDTO.setBetAmt(totalBetAmt);
			//Update Player table
			playersDAO.merge(playerDTO);
			
			//Start for LoyalPoints calculation
			Integer loyalPointID = loyalPointsDAO.getPointIDBasedOnBet(totalBetAmt);
			List<PlayersLoyalpointsDTO> playerLoyalDTOList = playerLoyalPointsDAO.findByPlayerId(playerID);
			PlayersLoyalpointsDTO playerLoyalDTO = new PlayersLoyalpointsDTO();
			if(playerLoyalDTOList!=null && !playerLoyalDTOList.isEmpty()){
				playerLoyalDTO = playerLoyalDTOList.get(0);
				playerLoyalDTO.setLoyalpointsId(loyalPointID);
				//TODO Temp hard coded
				playerLoyalDTO.setUpdatedBy("Admin");
				playerLoyalDTO.setUpdatedTimestamp(new Date());
			} else {
				playerLoyalDTO.setLoyalpointsId(loyalPointID);
				playerLoyalDTO.setPlayerId(playerID);
				//TODO Temp hard coded
				playerLoyalDTO.setCreatedBy("Admin");
				playerLoyalDTO.setCreatedTimestamp(new Date());
			}
			//Update Player Loyal Points mapping table
			playerLoyalPointsDAO.merge(playerLoyalDTO);
			
			//Start for Level calculation
			Integer levelID = levelDAO.getLevelIDFromPoints(loyalPointID);
			PlayersLevelDTO playerLevelDTO = new PlayersLevelDTO();
			List<PlayersLevelDTO> playersLevelDTO = playerLevelDAO.findByPlayerId(playerID);
			if(playerLevelDAO.findByPlayerId(playerID)!=null && !playersLevelDTO.isEmpty()){
				playerLoyalDTO.setLoyalpointsId(loyalPointID);
				//TODO Temp hard coded
				playerLoyalDTO.setUpdatedBy("Admin");
				playerLoyalDTO.setUpdatedTimestamp(new Date());
			} else {
				playerLoyalDTO = new PlayersLoyalpointsDTO();
				playerLoyalDTO.setLoyalpointsId(loyalPointID);
				playerLoyalDTO.setPlayerId(playerID);
				//TODO Temp hard coded
				playerLoyalDTO.setCreatedBy("Admin");
				playerLoyalDTO.setCreatedTimestamp(new Date());
			}
			//Update Player Loyal Points mapping table
			playerLoyalPointsDAO.merge(playerLoyalDTO);
			
			
			lastID = i;
		}
		
		//Store LastID
		storeConfigurationBasedParam("lastID", "configTable", String.valueOf(lastID));
		
		// On successful update
		success = true;
		
		// if all operation is completed finish with success true status
		return success;
	}
	
	private boolean storeConfigurationBasedParam(String parameterRequested, String configTable, String value){
		int paramValue = 600;
		return true;
	}
	
	private int retrieveConfigurationBasedOnParam(String parameterRequested, String configTable){
		//Sample param retrieved for noOfRows to be updated
		int paramValue = 200;
		
		//Sample param to get start ID
		paramValue = 400;
		
		return paramValue;
	}

}
