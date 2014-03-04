package com.loyal.scheduler;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ExecuteJob implements Job{
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		 		//TODO write code logic here to call the respective operation
				System.out.println("Hello Quartz! Running from wrong place");	
		 
			}

}
