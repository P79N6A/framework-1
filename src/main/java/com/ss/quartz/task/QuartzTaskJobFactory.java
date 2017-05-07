/**  <p>.</p> */
package com.ss.quartz.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ss.quartz.entity.TaskJob;
import com.ss.quartz.util.QuartzUtil;

/**
 * <p> QuartzJobTaskFactory.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月16日: 上午10:38:57
 */
public class QuartzTaskJobFactory implements Job {

	/**
	 *(non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		TaskJob scheduleJob = (TaskJob) arg0.getMergedJobDataMap().get("taskJob");
		QuartzUtil.reflectionUtil.invokMethod(scheduleJob);

	}

}
