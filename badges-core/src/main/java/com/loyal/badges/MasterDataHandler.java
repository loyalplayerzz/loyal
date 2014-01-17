package com.loyal.badges;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.badges.dto.InsertGameRoundMasterObj;
import com.loyal.common.db.DbUtility;

public class MasterDataHandler {
    private static Map<String, String> providerGame = new HashMap<String, String>();
    private static Map<Integer, String> players = new HashMap<Integer, String>();
    private static Map<Double, Double> betAndWin = new HashMap<Double, Double>();
    private static Map<Integer, Date> gameRoundDate = new HashMap<Integer, Date>();
    
    private static int GAME_LIST_SIZE = 100;
    private static int GAMES_PER_PROVIDER = 10;
    private static int PLAYER_LIST_SIZE = 100;
    private static int GAMEROUNDDATE_LIST_SIZE = 100;
    private static int DATA_ROW_SIZE = 700; // you can select maximum upto 1000 after that it does not matter what you define 
    
    private static final Logger LOG = LoggerFactory.getLogger(MasterDataHandler.class);
    
    public void insertGameRoundMasterData(ArrayList<InsertGameRoundMasterObj> insertDataList){
        String sql = "insert into game_round_master (game_round_id, gameId, game_provider, transaction_type,player_id,casino_currency_bet,casino_currency_win,game_round_start_date,game_round_end_date)"
                + " VALUES (?,?,?,?,?,?,?,?,?);";
        Connection conn = DbUtility.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            LOG.info("Just before the setting up the test Data");
            setupTestData();
            LOG.info("After setting up the test Data");
            ArrayList<InsertGameRoundMasterObj> insertDataList = (ArrayList<InsertGameRoundMasterObj>) getDataListToInsert();
            
            for(InsertGameRoundMasterObj obj : insertDataList){
                java.sql.Timestamp sql_startDate = new java.sql.Timestamp(obj.getGameRoundStartDate().getTime());
                java.sql.Timestamp sql_endDate = new java.sql.Timestamp(obj.getGameRoundEndDate().getTime());
                ps.setString(1, obj.getGameRoundId());
                ps.setString(2, obj.getGameId());
                ps.setString(3, obj.getProvider());
                ps.setString(4, obj.getTrasactionType());
                ps.setString(5, obj.getPlayerId());
                ps.setDouble(6, obj.getTotalBet());
                ps.setDouble(7, obj.getTotalWin());
                ps.setTimestamp(8,  sql_startDate);
                ps.setTimestamp(9,  sql_endDate);
                
                ps.executeUpdate();
            }
            LOG.info("After Inserting the data in the database");
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static List<InsertGameRoundMasterObj> getDataListToInsert() {
        List<InsertGameRoundMasterObj> insertDataList = new ArrayList<InsertGameRoundMasterObj>();
        List<String> gameKeys = new ArrayList<String>(providerGame.keySet());
        List<Double> betKeys = new ArrayList<Double>(betAndWin.keySet());
        int lastGameRoundInDb = getLastGameRoundId();
        for(int i=0;i<DATA_ROW_SIZE;i++){
            InsertGameRoundMasterObj dataObj = new InsertGameRoundMasterObj();
            //int randIndex = randInt(1,GAME_LIST_SIZE);
            String gameId = (String)gameKeys.get(randInt(1,GAME_LIST_SIZE-1));
            dataObj.setGameId(gameId);
            dataObj.setProvider(providerGame.get(gameId));
            int gameRoundId = lastGameRoundInDb+i;
            dataObj.setGameRoundId(gameRoundId+"");
            dataObj.setPlayerId(players.get(randInt(1,PLAYER_LIST_SIZE-1)));
            dataObj.setTrasactionType("GAME_PLAY");
            Date endDate = gameRoundDate.get(randInt(1,GAMEROUNDDATE_LIST_SIZE));
            Date startDate = new Date(endDate.getTime()-2000);
            dataObj.setGameRoundStartDate(startDate);
            dataObj.setGameRoundEndDate(endDate);
            Double bet = betKeys.get(randInt(1,13));
            dataObj.setTotalBet(bet);
            dataObj.setTotalWin(betAndWin.get(bet));
            insertDataList.add(dataObj);
        }
        return insertDataList;
    }
    private static int getLastGameRoundId() {
        String sql = "select MAX(game_round_id) roundId from game_round_master";
        int gameRoundId = 0;
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                String roundId = res.getString("roundId");
                if(roundId != null && !roundId.equals("")){
                    gameRoundId = Integer.parseInt(roundId);
                    gameRoundId = gameRoundId+1;
                }
            }
            ps.close();
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return gameRoundId;
    }
    private static void setupTestData(){
        setUpProviderGames();
        setUpPlayers();
        setUpBetAndWin();
        setUpGameRoundDate();
    }
    
    private static void setUpPlayers(){
        for(int i=1;i<PLAYER_LIST_SIZE+1;i++){
            players.put(i, "player"+i);
        }
    }
    private static void setUpGameRoundDate(){
        for(int i=1;i<GAMEROUNDDATE_LIST_SIZE+1;i++){
            gameRoundDate.put(i, getRandomDate());
        }
    }
    private static Date getRandomDate(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2013);
        cal.set(Calendar.MONTH, randInt(1,12));
        cal.set(Calendar.DAY_OF_MONTH, randInt(1,27));
        cal.set(Calendar.HOUR, randInt(1,23));
        cal.set(Calendar.MINUTE, randInt(1,50));
        cal.set(Calendar.SECOND, randInt(1,55));
        return cal.getTime();
    }
    private static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
        //return randomNum;
    }
    private static void setUpBetAndWin(){
        betAndWin.put(1.00, 2.00);
        betAndWin.put(2.00, 0.00);
        betAndWin.put(3.00, 0.00);
        betAndWin.put(4.00, 20.00);
        betAndWin.put(5.00, 29.00);
        betAndWin.put(6.00, 0.00);
        betAndWin.put(7.00, 250.00);
        betAndWin.put(8.00, 0.00);
        betAndWin.put(9.00, 200.00);
        betAndWin.put(10.00, 60.00);
        betAndWin.put(11.00, 0.00);
        betAndWin.put(12.00, 24.00);
        betAndWin.put(14.00, 0.00);
        betAndWin.put(14.00, 22.00);
        betAndWin.put(15.00, 27.00);
        
    }
    private static void setUpProviderGames(){
        for(int i=0;i<GAME_LIST_SIZE+1;i++){
            for(int j=1;j<GAMES_PER_PROVIDER+1;j++){
                providerGame.put("game"+i, "provider"+j);
                i++;
            }
        }
    }
    
    public static boolean isThisJobActive() {
        String sql = "select * from jobs_details where job_name = 'MASTER_DATA'";
        boolean activeFlag = false;
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                String active = res.getString("active");
                if(active != null && active.equalsIgnoreCase("Y")){
                    activeFlag = true;
                }
            }
            ps.close();
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return activeFlag;
    }
}
