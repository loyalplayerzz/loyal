package com.loyal.badges.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import au.com.bytecode.opencsv.CSVReader;

import com.loyal.badges.BadgeDetailsHandler;
import com.loyal.badges.MasterDataHandler;
import com.loyal.badges.SummaryDataHandler;
import com.loyal.badges.dto.InsertGameRoundMasterObj;
import com.loyal.common.db.DbUtility;

/**
 * Servlet implementation class GameRoundMaster
 */
public class GameRoundMaster extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String[] allTableNames = {"GAME_ROUND_MASTER", "GAME_ROUND_SUMMARY","PLAYER_BADGE_DETAILS","JOB_AUDIT_DETAILS"};
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameRoundMaster() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    processRequest(request, response);
	}
	

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String fileName = request.getParameter("fileName");
        HttpSession session = request.getSession(false);
        //String fileName = "F:\\loyal_source_code_dev\\dev\\master.csv";
        if(action != null && action.equalsIgnoreCase("loaddata")){
            processCsvFile(fileName);
            session.setAttribute("MESSAGE", "DATA LOADED SUCCESSFULLY FROM FILE");
        }else if(action != null && action.equalsIgnoreCase("executejobs")){
            processLoadedData();
            session.setAttribute("MESSAGE", "JOBS HAS BEEN EXECUTED SUCCESSFULLY");
        }else if(action != null && action.equalsIgnoreCase("deletedata")){
            deleteInsertedTestData(request);
            session.setAttribute("MESSAGE", "DATA DELETED SUCCESSFULLY FOR TEH SELECTED TABLES");
        }else if(action != null && action.equalsIgnoreCase("deletealldata")){
            deleteAllInsertedTestData(request);
            session.setAttribute("MESSAGE", "DATA DELETED SUCCESSFULLY FOR ALL THE TABLES");
        }else{
            //action will be null in case of file upload
            processLoadedFile(request, response);
            session.setAttribute("MESSAGE", "CSV FILE LOADED AND PPARSED SUCCESSFULLY");
        }
        String path = "/badge-services/loadrounddata.jsp";
        response.sendRedirect(path);
        //RequestDispatcher rd = request.getRequestDispatcher(path);
        //rd.include(request, response);
        //rd.forward(request, response);
    }
    
    private void deleteInsertedTestData(HttpServletRequest request) {
        String[] tableNames = request.getParameterValues("dataTables");
        deleteTableData(tableNames);
        
    }
    
    private void deleteAllInsertedTestData(HttpServletRequest request) {
        deleteTableData(allTableNames);
    }
    
    private void deleteTableData(String[] tableNames){
        String sql_master="TRUNCATE TABLE GAME_ROUND_MASTER";
        String sql_summary="TRUNCATE TABLE GAME_ROUND_SUMMARY";
        String sql_playerBadge="TRUNCATE TABLE PLAYER_BADGE_DETAILS";
        String sql_jobAudit="TRUNCATE TABLE JOB_AUDIT_DETAILS";
        Connection conn = DbUtility.getConnection();
        PreparedStatement ps = null;
        try {
            if(tableNames != null && tableNames.length>0){
                for(int i=0;i<tableNames.length;i++){
                    if(tableNames[i].equalsIgnoreCase("GAME_ROUND_MASTER")){
                        ps = conn.prepareStatement(sql_master);
                        ps.execute();
                    }else if(tableNames[i].equalsIgnoreCase("GAME_ROUND_SUMMARY")){
                        ps = conn.prepareStatement(sql_summary);
                        ps.execute();
                    }else if(tableNames[i].equalsIgnoreCase("PLAYER_BADGE_DETAILS")){
                        ps = conn.prepareStatement(sql_playerBadge);
                        ps.execute();
                    }else if(tableNames[i].equalsIgnoreCase("JOB_AUDIT_DETAILS")){
                        ps = conn.prepareStatement(sql_jobAudit);
                        ps.execute();
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(ps!=null){
                    ps.close();
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void processLoadedFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            ArrayList<InsertGameRoundMasterObj> csvData = new ArrayList<InsertGameRoundMasterObj>();
            for (FileItem item : items) {
                if(!item.isFormField()){
                    InputStream is = item.getInputStream();
                    String contentAsString = IOUtils.toString(is, "UTF-8");
                    String[] dataRows = contentAsString.split("\r\n");
                    for(int i=1;i<dataRows.length;i++){
                        InsertGameRoundMasterObj dataObj = getRoundDataFromLine(dataRows[i].split("\\s*,\\s*"), i);
                        csvData.add(dataObj);
                    }
                    MasterDataHandler masterDataHandler = new MasterDataHandler();
                    masterDataHandler.insertGameRoundMasterData(csvData);
                }
            }
        }catch (FileUploadException e) {
            System.out.println("ERROR MESSAGAE  FILEUPLOAD  "+e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.out.println("ERROR MESSAGAE  IO  "+e.getMessage());
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("ERROR MESSAGAE EXCEPTION   "+e.getMessage());
            e.printStackTrace();
        }
        
    }

    private static void processLoadedData(){
        SummaryDataHandler summaryDataHandler = new SummaryDataHandler();
        summaryDataHandler.analyzeGameRoundMasterData();
        BadgeDetailsHandler badgeDetailsHandler = new BadgeDetailsHandler();
        badgeDetailsHandler.calculateBadgeDetailsForPlayers();
    }
    
    private static void processCsvFile(String fileName){
        ArrayList<InsertGameRoundMasterObj> csvData = new ArrayList<InsertGameRoundMasterObj>();
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            String [] nextLine;
            int lineNumber = -1;
            while ((nextLine = reader.readNext()) != null) {
                lineNumber++;
                if(lineNumber > 0 && nextLine.length >1){
                    if(!validateLine(nextLine)){
                        throw new Exception("PROBLEM IN LINE NUMBER ----    "+lineNumber);
                    }
                    InsertGameRoundMasterObj roundData = getRoundDataFromLine(nextLine, lineNumber);
                    csvData.add(roundData);
                }
            }
            MasterDataHandler masterDataHandler = new MasterDataHandler();
            masterDataHandler.insertGameRoundMasterData(csvData);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static InsertGameRoundMasterObj getRoundDataFromLine(String[] nextLine, int lineNumber) {
        InsertGameRoundMasterObj insertData = new InsertGameRoundMasterObj();
        MasterDataHandler masterDataHandler = new MasterDataHandler();
        int gameRoundId = masterDataHandler.getLastGameRoundId();
        insertData.setGameId(nextLine[0]);
        insertData.setGameRoundId(gameRoundId+lineNumber+"");
        insertData.setGameRoundStartDate(getFormattedDate(nextLine[1]));
        insertData.setGameRoundEndDate(getFormattedDate(nextLine[2]));
        insertData.setTotalBet(Double.parseDouble(nextLine[3]));
        insertData.setTotalWin(Double.parseDouble(nextLine[4]));
        insertData.setTrasactionType("GAME_PLAY");
        insertData.setPlayerId(nextLine[5]);
        insertData.setProvider(nextLine[6]);
        System.out.println(insertData.toString());
        
        return insertData;
    }
    
    private static Date getFormattedDate(String dateStr){
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    private static boolean validateLine(String[] nextLine) {
        String err = "NO";
        if(nextLine != null && nextLine.length >0){
           if(nextLine.length != 7){
               err = "YES";
           }else{
               for(int i=0;i<nextLine.length;i++){
                   if(nextLine[i] == null || nextLine[i].trim().equals("")){
                       err = "YES";
                   }
               }
           }
        }else{
            err = "YES";
        }
        if(err.equals("NO")){
            return true;
        }
        return false;
        
    }

}
