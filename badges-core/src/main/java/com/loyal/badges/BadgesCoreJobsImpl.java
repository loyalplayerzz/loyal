package com.loyal.badges;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.loyal.badges.api.BadgesCoreJobsApi;

public class BadgesCoreJobsImpl implements BadgesCoreJobsApi {
    
    private static final Logger LOG = LoggerFactory.getLogger(BadgesCoreJobsImpl.class);
    
    @Override
    public void insertMasterData() {
        MasterDataHandler masterDataHandler = new MasterDataHandler();
        if(masterDataHandler.isThisJobActive()){
            masterDataHandler.insertGameRoundMasterData();
        }
    }

    @Override
    public void analyzeMasterData() {
        SummaryDataHandler summaryDataHandler = new SummaryDataHandler();
        if(summaryDataHandler.isThisJobActive()){
            summaryDataHandler.analyzeGameRoundMasterData();
        }
    }

    @Override
    public void calculateBadgeDetails() {
        BadgeDetailsHandler badgeDetailsHandler = new BadgeDetailsHandler();
        if(badgeDetailsHandler.isThisJobActive()){
            badgeDetailsHandler.calculateBadgeDetailsForPlayers();
        }
    }

}
