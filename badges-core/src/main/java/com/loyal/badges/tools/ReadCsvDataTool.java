package com.loyal.badges.tools;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import au.com.bytecode.opencsv.CSVReader;

import com.loyal.badges.MasterDataHandler;
import com.loyal.badges.dto.InsertGameRoundMasterObj;

public class ReadCsvDataTool {

    public static void main(String[] args) {
        //String action = request.getParameter("action");
        //String fileName = request.getParameter("fileName");
        String fileName = "F:\\loyal_source_code_dev\\dev\\master.csv";
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
