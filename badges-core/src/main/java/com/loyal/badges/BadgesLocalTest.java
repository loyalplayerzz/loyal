package com.loyal.badges;

import com.loyal.badges.api.BadgesCoreJobsApi;

public class BadgesLocalTest {

    public static void main(String[] args){
        BadgesCoreJobsApi jobsHandle = new BadgesCoreJobsImpl();
        jobsHandle.insertMasterData();
        jobsHandle.analyzeMasterData();
        jobsHandle.calculateBadgeDetails();
    }

}
