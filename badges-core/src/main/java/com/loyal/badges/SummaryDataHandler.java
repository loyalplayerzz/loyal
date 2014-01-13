package com.loyal.badges;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.common.db.DbUtility;

public class SummaryDataHandler {
    
    private static final Logger LOG = LoggerFactory.getLogger(SummaryDataHandler.class);
    
    public void analyzeGameRoundMasterData(){
        LOG.info("Just about to run the job to analyze the game round data");
        Connection conn = DbUtility.getConnection();
        String procName = "{ call analyze_game_round() }";
        CallableStatement cs = null;
        try {
            cs = conn.prepareCall(procName);
            cs.execute();
            LOG.info("Now analysis has been done and everything went fine");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                cs.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static boolean isThisJobActive() {
        String sql = "select * from jobs_details where job_name = 'SUMMARY_DATA'";
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
