package com.loyal.scheduler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzServlet extends HttpServlet{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = -1534112052254724864L;

		public void init(ServletConfig cfg) {
	        String key = "org.quartz.impl.StdSchedulerFactory.KEY";
	        ServletContext servletContext = cfg.getServletContext();
	        StdSchedulerFactory factory = (StdSchedulerFactory) servletContext.getAttribute(key);
	        try {
				Scheduler scheduler = factory.getScheduler("MyQuartzScheduler");
				scheduler.start();
				/*// TODO use quartzScheduler here.
		        JobDetail job = new JobDetail();
				job.setName("DataSummary");
				job.setJobClass(ExecuteJob.class);

				CronTrigger trigger = new CronTrigger();
				trigger.setName("DataTrigger");
				// Execute Every 1 hr
				trigger.setCronExpression("0/5 * * * * ?");
				
				
				scheduler.scheduleJob(job, trigger);*/
			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
	        
	    }
}
