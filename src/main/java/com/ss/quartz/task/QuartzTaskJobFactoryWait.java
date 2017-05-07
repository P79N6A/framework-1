package com.ss.quartz.task;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ss.quartz.entity.TaskJob;
import com.ss.quartz.util.QuartzUtil;


/**
 * <p> QuartzTaskJobFactoryWait.java.</p>
 * <p>Description:若一个方法一次执行不完下次轮转时则等待改方法执行完后才执行下一次操作  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月16日: 下午3:05:24
 */
@DisallowConcurrentExecution
public class QuartzTaskJobFactoryWait implements Job {
	public final Logger log = Logger.getLogger(this.getClass());

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		TaskJob scheduleJob = (TaskJob) context.getMergedJobDataMap().get("taskJob");
		QuartzUtil.reflectionUtil.invokMethod(scheduleJob);

	}
}