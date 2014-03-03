package com.loyal.badges;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.badges.dto.BadgeDetailsObj;
import com.loyal.badges.dto.GameRoundSummaryObj;
import com.loyal.badges.dto.PlayerBadgeObj;
import com.loyal.common.db.DbUtility;

public class BadgeDetailsHandler {
    
    private static int insertedAuditId = 0;
    private static final Logger LOG = LoggerFactory.getLogger(BadgeDetailsHandler.class);
    
    public void calculateBadgeDetailsForPlayers(){
        try{
            LOG.info("About to run the job to calculate Badges");
            int lastProcessedRowNum = getLastProcessedRowsAndUpdateAudit();
            LOG.info("lastProcessedRowNum -   "+lastProcessedRowNum);
            System.out.println("lastProcessedRowNum -   "+lastProcessedRowNum);
            Set<String> uniquePlayerIds = new HashSet<String>();
            int lastAvailableRowNum = getIdOfLastAvailableRecord();
            LOG.info("lastAvailableRowNum -   "+lastAvailableRowNum);
            System.out.println("lastAvailableRowNum -   "+lastAvailableRowNum);
            uniquePlayerIds = getUniquePlayerIds(lastProcessedRowNum, lastAvailableRowNum);
            LOG.info("No. of unique players to process -   "+uniquePlayerIds.size());
            System.out.println("No. of unique players to process -   "+uniquePlayerIds.size());
            processRawDataToCalculateBadge(uniquePlayerIds);
            updateAuditAfterSuccess(lastAvailableRowNum);
        
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void processRawDataToCalculateBadge(Set<String> playerIds) throws IllegalAccessException, InvocationTargetException{
        List<BadgeDetailsObj> badgeDetailsList = getBadgeDetails();
        LOG.info("total no. of badges configured -   "+badgeDetailsList.size());
        System.out.println("total no. of badges configured -   "+badgeDetailsList.size());
        for(String playerId : playerIds){
            int rowNum = 0;
            for(BadgeDetailsObj badgeObj : badgeDetailsList){
                rowNum = getLastAwardedBadgeRow(playerId, badgeObj);
                List<GameRoundSummaryObj> playerSpecificData = getPlayerRoundSummaryList(playerId, rowNum);
                LOG.info("No of player Specific Data list size -   "+playerSpecificData.size());
                processPlayerDataForBadge(playerSpecificData, badgeObj);
            }
        }
    }
    
    
    private static void processPlayerDataForBadge(List<GameRoundSummaryObj> playerDataList, BadgeDetailsObj badgeObj){
        if(badgeObj.getBadgeType().equalsIgnoreCase("TROPG")){
            List<GameRoundSummaryObj> awardedBadgeList = processAlgorithm_tropg(playerDataList, badgeObj);
            if(awardedBadgeList != null && awardedBadgeList.size()>0){
                for(GameRoundSummaryObj gameRoundData : awardedBadgeList){
                    awardBadgeForPlayer(getPlayerBadgeObj(gameRoundData, badgeObj.getBadgeId(), "TROPG"));
                }
            }
            
        }else if(badgeObj.getBadgeType().equalsIgnoreCase("TBOP")){
            List<GameRoundSummaryObj> awardedBadgeList =  processAlgorithm_tbop(playerDataList, badgeObj);
            if(awardedBadgeList != null && awardedBadgeList.size()>0){
                for(GameRoundSummaryObj gameRoundData : awardedBadgeList){
                    awardBadgeForPlayer(getPlayerBadgeObj(gameRoundData, badgeObj.getBadgeId(), "TBOP"));
                }
            }
        }
    }
    
    private static PlayerBadgeObj getPlayerBadgeObj(GameRoundSummaryObj roundData, String badgeId, String badgeType) {
        PlayerBadgeObj badgeObj = new PlayerBadgeObj();
        badgeObj.setBadgeId(badgeId);
        badgeObj.setBadgeType(badgeType);
        badgeObj.setPlayerId(roundData.getPlayerId());
        badgeObj.setRowNum(Integer.parseInt(roundData.getRowId()));
        badgeObj.setBadgeDate(roundData.getGameRoundDate());
        return badgeObj;
    }

    private static List<GameRoundSummaryObj> processAlgorithm_tropg(List<GameRoundSummaryObj> playerDataList, BadgeDetailsObj badgeObj){
        List<GameRoundSummaryObj> badgeList = new ArrayList<GameRoundSummaryObj>();
        int sumOfGameRounds = 0;
        for(int i =0; i<playerDataList.size();i++){
            GameRoundSummaryObj playerObj = playerDataList.get(i);
            int daysToCheck = badgeObj.getNoOfDays();
            if(daysToCheck > 0){
                sumOfGameRounds = 0;
                for(int j=1;j<daysToCheck;j++){
                    if(i+j < playerDataList.size()){
                        if(checkIfRowHasToBeAdded(badgeObj, playerObj)){
                            sumOfGameRounds=sumOfGameRounds+playerObj.getNoOfGameRounds()+playerDataList.get(i+j).getNoOfGameRounds();
                        }
                        if(sumOfGameRounds > badgeObj.getNoOfRounds()){
                            badgeList.add(playerDataList.get(i+j));
                            break;
                        }
                    }
                }
                
            }else{
                sumOfGameRounds=sumOfGameRounds+playerObj.getNoOfGameRounds();
                if(sumOfGameRounds > badgeObj.getNoOfRounds()){
                    badgeList.add(playerObj);
                    break;
                }
            }
        }
        return badgeList;
    }
    
    private static boolean checkIfRowHasToBeAdded(BadgeDetailsObj badgeObj, GameRoundSummaryObj playerDataObj) {
        if(badgeObj.isAllProviderSelected() && badgeObj.isAllGamesSelested()){
            return true;
        }else if(badgeObj.isAllProviderSelected() && !badgeObj.isAllGamesSelested()){
            if(badgeObj.getGames().contains(playerDataObj.getGameId())){
                return true;
            }else{
                return false;
            }
        }else if(!badgeObj.isAllProviderSelected() && !badgeObj.isAllGamesSelested()){
            if(badgeObj.getGames().contains(playerDataObj.getGameId()) && badgeObj.getProviders().contains(playerDataObj.getProvider())){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    private static List<GameRoundSummaryObj> processAlgorithm_tbop(List<GameRoundSummaryObj> playerDataList, BadgeDetailsObj badgeObj){
        List<GameRoundSummaryObj> badgeList = new ArrayList<GameRoundSummaryObj>();
        double betSum = 0.00;
        for(int i =0; i<playerDataList.size();i++){
            GameRoundSummaryObj playerObj = playerDataList.get(i);
            int daysToCheck = badgeObj.getNoOfDays();
            if(daysToCheck > 0){
                betSum = 0.00;
                for(int j=1;j<daysToCheck;j++){
                    if(i+j < playerDataList.size()){
                        if(checkIfRowHasToBeAdded(badgeObj, playerObj)){
                            betSum=betSum+playerObj.getTotalBet()+playerDataList.get(i+j).getTotalBet();
                        }
                        if(betSum > badgeObj.getBetAmount()){
                            badgeList.add(playerDataList.get(i+j));
                            break;
                        }
                    }
                }
                
            }else{
                betSum=betSum+playerObj.getTotalBet();
                if(betSum > badgeObj.getBetAmount()){
                    badgeList.add(playerObj);
                    break;
                }
            }
        }
        return badgeList;
    }
    
    private static List<GameRoundSummaryObj> getPlayerRoundSummaryList(String playerId, int rowId){
        String sql = "SELECT * FROM loyal.game_round_summary where player_id = ? and  id > ? order by id asc;";
        List<GameRoundSummaryObj> rawSummaryData = new ArrayList<GameRoundSummaryObj>();
        try {
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, playerId);
            ps.setInt(2, rowId);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                GameRoundSummaryObj rawObj = new GameRoundSummaryObj();
                rawObj.setRowId(res.getString("id"));
                rawObj.setPlayerId(res.getString("player_id"));
                rawObj.setProvider(res.getString("provider"));
                rawObj.setGameId(res.getString("gameId"));
                rawObj.setGameRoundDate(new Date(res.getDate("game_round_date").getTime()));
                rawObj.setNoOfGameRounds(res.getInt("game_rounds"));
                rawObj.setTotalBet(res.getDouble("total_bet"));
                rawObj.setTotalWin(res.getDouble("total_win"));
                rawSummaryData.add(rawObj);
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rawSummaryData;
    }
    
    private static void awardBadgeForPlayer(PlayerBadgeObj playerBadge){
        String sql = "INSERT INTO PLAYER_BADGE_DETAILS (player_id, badge_id, badge_type, badge_date, row_id) values (?,?,?,?,?);";
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, playerBadge.getPlayerId());
            ps.setString(2, playerBadge.getBadgeId());
            ps.setString(3, playerBadge.getBadgeType());
            ps.setTimestamp(4,  new java.sql.Timestamp(playerBadge.getBadgeDate().getTime()));
            ps.setInt(5, playerBadge.getRowNum());
            ps.executeUpdate();
            ps.close();
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private static void insertNewAudit(int rowId, int rowsProcessed){
        String sql = "INSERT INTO job_audit_details (jobId, start_date, job_type, job_status, row_id_start) values (?,?,?,?,?);";
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "BADGES");
            ps.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
            ps.setString(3,  "BADGE");
            ps.setString(4,  "START");
            ps.setInt(5,  rowsProcessed+1);
            ps.executeUpdate();
            ResultSet rs =  ps.getGeneratedKeys();
            if(rs.next()){
                insertedAuditId = rs.getInt(1);
            }
            ps.close();
            conn.close();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private static void updateAuditAfterSuccess(int rowId){
        String sql = "UPDATE job_audit_details set end_date = ?, row_id_end = ?, job_status = 'SUCCESS' where id=?;";
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
            ps.setInt(2,  rowId);
            ps.setInt(3,  insertedAuditId);
            ps.executeUpdate();
            ps.close();
            conn.close();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    private static int getLastProcessedRowsAndUpdateAudit(){
        int rowId = 0;
        int rowsProcessed = 0;
        String sql_select = "select * from job_audit_details where job_status = 'SUCCESS' and jobId='BADGES' order by id desc limit 1;";
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                rowId = res.getInt("id");
                rowsProcessed = res.getInt("row_id_end");
            }
            insertNewAudit(rowId, rowsProcessed);
            ps.close();
            conn.close();
              
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rowsProcessed;
    }
    
    private static Set<String> getUniquePlayerIds(int rowNumStart, int rowNumEnd){
        Set<String> uniquePlayerIds = new HashSet<String>();
        String sql_select = "SELECT distinct(player_id) player_id FROM game_round_summary where id > ? and id <= ?";
        try {
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ps.setInt(1, rowNumStart);
            ps.setInt(2, rowNumEnd);
            ResultSet res = ps.executeQuery();
             while (res.next()) {
                uniquePlayerIds.add(res.getString("player_id"));
            }
             ps.close();
             conn.close();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return uniquePlayerIds;
    }
    
    private static int getLastAwardedBadgeRow(String playerId, BadgeDetailsObj badgeObj) {
        int rowId = 0;
        String sql_select = "SELECT MAX(row_id) row_num FROM loyal.player_badge_details where player_id = ?;";
        try {
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ps.setString(1, playerId);
            ResultSet res = ps.executeQuery();
             while (res.next()) {
                rowId = res.getInt("row_num");
            }
             ps.close();
             conn.close();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowId;
    }
    
    private static int getIdOfLastAvailableRecord(){
        int rowId = 0;
        String sql_select = "select MAX(id) id from game_round_summary;";
        try {
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet res = ps.executeQuery();
             while (res.next()) {
                rowId = res.getInt("id");
            }
             ps.close();
             conn.close();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowId;
    }

    private static List<BadgeDetailsObj> getBadgeDetails(){
        List<BadgeDetailsObj> badgesAndAlgos = getBadgesAndAlgos();
        List<BadgeDetailsObj> badgesAndAlgosWithGameProviderList = new ArrayList<BadgeDetailsObj>();
        for(BadgeDetailsObj badgeObj : badgesAndAlgos){
            if(!badgeObj.isAllGamesSelested()){
                List<String> games = getSelectedGames(badgeObj.getAlgoId(), badgeObj.getBadgeType());
                badgeObj.setGames(games);
            }
            if(!badgeObj.isAllProviderSelected()){
                List<String> providers = getSelectedProviders(badgeObj.getAlgoId(), badgeObj.getBadgeType());
                badgeObj.setProviders(providers);
            }
            badgesAndAlgosWithGameProviderList.add(badgeObj);
        }
        badgesAndAlgos.clear();
        return badgesAndAlgosWithGameProviderList;
    }
    
    private static List<String> getSelectedGames(String algoId, String badgeType) {
        List<String> games = new ArrayList<String>();
        String sql_select = "SELECT * FROM ALGO_GAMES WHERE ALGO_ID = ? AND ALGO_TYPE= ? AND ACTIVE = 'Y';";
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ps.setString(1, algoId);
            ps.setString(2, badgeType);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                games.add(res.getString("game"));
            }
            ps.close();
            conn.close();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return games;
    }
    private static List<String> getSelectedProviders(String algoId, String badgeType) {
        List<String> providers = new ArrayList<String>();
        String sql_select = "SELECT * FROM ALGO_PROVIDERS WHERE ALGO_ID = ? AND ALGO_TYPE= ? AND ACTIVE = 'Y';";
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ps.setString(1, algoId);
            ps.setString(2, badgeType);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                providers.add(res.getString("provider"));
            }
            ps.close();
            conn.close();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return providers;
    }
    
    public static boolean isThisJobActive() {
        String sql = "select * from jobs_details where job_name = 'BADGE_DETAILS'";
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

    private static List<BadgeDetailsObj> getBadgesAndAlgos(){
        List<BadgeDetailsObj> badges = new ArrayList<BadgeDetailsObj>();
        String sql_select = "SELECT bdg.badge_id, bdg.algo_id, bdg.algo_type,"
                +" tbop.providers tbop_providers, tbop.games tbop_games, tbop.bet_amount, tbop.no_of_days tbop_days,"
                +" trog.providers trog_providers, trog.games trog_games, trog.no_of_game_rounds, trog.no_of_days trog_days"
                +" from badge_details bdg"
                +" LEFT JOIN algo_totalbetonprovider tbop ON bdg.algo_id=tbop.algo_id"
                +" LEFT JOIN algo_totalroundsongame trog ON bdg.algo_id=trog.algo_id"
                +" where bdg.active = 'Y'";
        
        try{
            Connection conn = DbUtility.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql_select);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                BadgeDetailsObj badgeObj = new BadgeDetailsObj();
                badgeObj.setBadgeId(res.getString("badge_id"));
                badgeObj.setAlgoId(res.getString("algo_id"));
                String badgeType = res.getString("algo_type");
                badgeObj.setBadgeType(badgeType);
                if(badgeType.equalsIgnoreCase("TBOP")){
                    int tbop_providers = res.getInt("tbop_providers");
                    int tbop_games = res.getInt("tbop_games");
                    if(tbop_providers > 0){
                        badgeObj.setAllProviderSelected(false);
                    }else{
                        badgeObj.setAllProviderSelected(true);
                    }
                    if(tbop_games > 0){
                        badgeObj.setAllGamesSelested(false);
                    }else{
                        badgeObj.setAllGamesSelested(true);
                    }
                    badgeObj.setNoOfDays(res.getInt("tbop_days"));
                    badgeObj.setBetAmount(res.getDouble("bet_amount"));
                }else if(badgeType.equalsIgnoreCase("TROG")){
                    int trog_providers = res.getInt("trog_providers");
                    int trog_games = res.getInt("trog_games");
                    if(trog_providers > 0){
                        badgeObj.setAllProviderSelected(false);
                    }else{
                        badgeObj.setAllProviderSelected(true);
                    }
                    if(trog_games > 0){
                        badgeObj.setAllGamesSelested(false);
                    }else{
                        badgeObj.setAllGamesSelested(true);
                    }
                    badgeObj.setNoOfDays(res.getInt("trog_days"));
                    badgeObj.setNoOfRounds(res.getInt("no_of_game_rounds"));
                }
                badges.add(badgeObj);
            }
            ps.close();
            conn.close();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return badges;
    }
        
    

}
