package com.loyal.badges.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.loyal.badges.BadgesCoreJobsImpl;
import com.loyal.badges.api.BadgesCoreJobsApi;

public class CalculateBadgesDetails implements Job{
	
	public void execute(JobExecutionContext context)throws JobExecutionException {
	    BadgesCoreJobsApi jobsHandle = new BadgesCoreJobsImpl();
	    jobsHandle.calculateBadgeDetails();
	}

}
