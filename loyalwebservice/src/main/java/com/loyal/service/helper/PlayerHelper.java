package com.loyal.service.helper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.loyal.persistence.dao.LevelMasterDAO;
import com.loyal.persistence.dao.PlayersBadgeDAO;
import com.loyal.persistence.dao.PlayersLevelDAO;
import com.loyal.persistence.dao.PlayersLoyalpointsDAO;
import com.loyal.persistence.dao.PlayersMasterDAO;
import com.loyal.persistence.dto.PlayersBadgeDTO;
import com.loyal.persistence.dto.PlayersLevelDTO;
import com.loyal.persistence.dto.PlayersLoyalpointsDTO;
import com.loyal.persistence.dto.PlayersMasterDTO;
import com.loyal.service.pojo.Player;

public class PlayerHelper {

	@Autowired
	public PlayersMasterDAO playersDAO;

	@Autowired
	public PlayersLevelDAO playersLevelDAO;
	
	@Autowired
	public LevelMasterDAO levelDAO;
	
	@Autowired
	public PlayersBadgeDAO playersBadgeDAO;

	public PlayersBadgeDAO getPlayersBadgeDAO() {
		return playersBadgeDAO;
	}

	public void setPlayersBadgeDAO(PlayersBadgeDAO playersBadgeDAO) {
		this.playersBadgeDAO = playersBadgeDAO;
	}

	public LevelMasterDAO getLevelDAO() {
		return levelDAO;
	}

	public void setLevelDAO(LevelMasterDAO levelDAO) {
		this.levelDAO = levelDAO;
	}

	@Autowired
	public PlayersLoyalpointsDAO playersLoyalPointsDAO;

	public PlayersMasterDAO getPlayersDAO() {
		return playersDAO;
	}

	public void setPlayersDAO(PlayersMasterDAO playersDAO) {
		this.playersDAO = playersDAO;
	}

	public PlayersLevelDAO getPlayersLevelDAO() {
		return playersLevelDAO;
	}

	public void setPlayersLevelDAO(PlayersLevelDAO playersLevelDAO) {
		this.playersLevelDAO = playersLevelDAO;
	}

	public PlayersLoyalpointsDAO getPlayersLoyalPointsDAO() {
		return playersLoyalPointsDAO;
	}

	public void setPlayersLoyalPointsDAO(
			PlayersLoyalpointsDAO playersLoyalPointsDAO) {
		this.playersLoyalPointsDAO = playersLoyalPointsDAO;
	}

	public Player getPlayerDetails(String userID){
		Player player = new Player();
		List<PlayersMasterDTO> playersDTOList = playersDAO.findByExternalUserId(userID);
		if(playersDTOList !=null && !playersDTOList.isEmpty()){
			//Player UserID
			player.setUserID(userID);
			List<PlayersLevelDTO> playersLevelDTOList = playersLevelDAO.findByPlayerId(playersDTOList.get(0).getId());
			if(playersLevelDTOList !=null && !playersLevelDTOList.isEmpty()){
				//Player Level
				player.setLevel(String.valueOf(playersLevelDTOList.get(0).getLevelId()));
				player.setLevelAwardedDate(convertDateToString(playersLevelDTOList.get(0).getCreatedTimestamp()));
			}
			
			List<PlayersLoyalpointsDTO> playersLoyalPointsList = playersLoyalPointsDAO.findByPlayerId(playersDTOList.get(0).getId());
			if(playersLoyalPointsList !=null && !playersLoyalPointsList.isEmpty()){
				//Player LoyalPoints
				player.setLoyalPoints(String.valueOf(playersLoyalPointsList.get(0).getLoyalpointsId()));
				player.setLoyalPointsAwardedDate(convertDateToString(playersLoyalPointsList.get(0).getCreatedTimestamp()));
			}
			
			List<PlayersBadgeDTO> playersBadgeList = playersBadgeDAO.findByPlayerId(playersDTOList.get(0).getId());
			HashMap<String, String> hsMap = new HashMap<String, String>();
			for(PlayersBadgeDTO playersBadge : playersBadgeList){
				hsMap.put(String.valueOf(playersBadge.getBadgeId()), convertDateToString(playersBadge.getCreatedTimestamp()));
			}
			player.setBadges(hsMap);
		}
		return new Player();
	}
	
	private String convertDateToString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public Player createPlayer(Player player) {

		return new Player();
	}

	public List<Player> retrieveAllPlayers(Integer limit) {
		return new ArrayList<Player>();
	}

}
