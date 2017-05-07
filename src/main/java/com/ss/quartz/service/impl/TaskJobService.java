package com.ss.quartz.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.framework.orm.page.Page;
import com.ss.quartz.dao.TaskJobDao;
import com.ss.quartz.entity.TaskJob;
import com.ss.quartz.service.ITaskJobService;
import com.ss.quartz.task.QuartzTaskJobFactory;
import com.ss.quartz.task.QuartzTaskJobFactoryWait;
import com.ss.quartz.util.QuartzUtil;

public class TaskJobService implements ITaskJobService{
	private TaskJobDao taskJobDao;
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	@Override
	public String insertDataBaseTaskJob(TaskJob taskJob) throws Exception{
		 taskJob.setCreateTime(QuartzUtil.dateUtil.getCurrentTimestamp());
		 taskJob.setJobId(QuartzUtil.pkUtil.getUuid());
		 //设置默认值未启动 0
		 taskJob.setJobStatus(TaskJob.JOB_STATUS_NOT_RUNNING);
		 //验证名称是否重复
		 if(selectTaskCountByTaskJob( taskJob) ){
			 throw new Exception("名称为："+taskJob.getJobName()+"已经存在") ;
		 }
		//验证表达式合法
		 validateJobCronExpression(taskJob.getCronExpression());
		 taskJobDao.insert("taskJob.insertTaskJob",  taskJob);
		 return taskJob.getJobId();
	}
	
	private  boolean  selectTaskCountByTaskJob(TaskJob taskJob) throws Exception{
		TaskJob seachTaskJob = new TaskJob();
		seachTaskJob.setJobName(null ==taskJob.getJobName()?null:taskJob.getJobName());
		seachTaskJob.setJobGroup(null ==taskJob.getJobGroup()?null:taskJob.getJobGroup());
		long count =  taskJobDao.getResultTypeCount("taskJob.selectTaskCountByTaskJob",  taskJob);
		if(count>0){
			return true;
		}
		return false;
	}
	

	/**
	 *<p>Description:数据库更新job  <p>注意：只有在jobStatus等于0的情况下才能更新  <p>只更新TaskJob  中不为空的字段   例如：实体中jobName为null 或者是“” 那么不更新 .</p> 
	 *<p>@param taskJob
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2015年7月16日: 下午2:18:40
	 *@author xubin
	 *@version 1.0
	 */
	private int updateDataBaseTaskJob(TaskJob taskJob) throws Exception{
		 TaskJob selecttaskJob =selectTaskJobById( taskJob.getJobId()) ;
		 if( null !=selecttaskJob){
			 taskJob.setUpdateTime(QuartzUtil.dateUtil.getCurrentTimestamp());
			 validateJobCronExpression(taskJob.getCronExpression());
			 return   taskJobDao.updateStatement("taskJob.updateTaskJob",  taskJob);
		 
		 }
		 return 0;
		
	}
	
	@Override
	public int deleteDataBaseTaskJobById(TaskJob taskJob) throws Exception{
		 TaskJob selecttaskJob =selectTaskJobById( taskJob.getJobId()) ;
		 if( null !=selecttaskJob){
			 if(TaskJob.JOB_STATUS_NOT_RUNNING.equals(selecttaskJob.getJobStatus())){
				 return    taskJobDao.delete("taskJob.deleteTaskJobById", selecttaskJob.getJobId());
			 }else if(TaskJob.JOB_STATUS_RUNNING.equals(selecttaskJob.getJobStatus())) {
				 throw new Exception("当前任务正在启动 请先停止当前任务");
			 }
			 return   taskJobDao.delete("taskJob.deleteTaskJobById", selecttaskJob.getJobId());
		 
		 }
		 return 0;
	}
	
	@Override
	public List<TaskJob> selectTaskJobList(TaskJob searchCondition) throws Exception{
		
	   return taskJobDao.getEntityList("taskJob.selectTaskJobList",searchCondition) ;
	}

	@Override
	public int updateRunJobStatus(String jobId,String cmd) throws Exception {
		if(QuartzUtil.stringUtil.isNotBlank(jobId)){
			TaskJob selectTask = selectTaskJobById(jobId);
			if(null!=selectTask ) {
				if(cmd.equals("start")){
					selectTask.setJobStatus(TaskJob.JOB_STATUS_RUNNING);
					insertRunJob(selectTask);
				}else if(cmd.equals("stop")){
					pauseJob(selectTask);
					selectTask.setJobStatus(TaskJob.JOB_STATUS_NOT_RUNNING);
				}
				return updateDataBaseTaskJob(selectTask) ;
			}
		}else {
		   return 0;
		}
		return 0;
	}
	
	/**
	 *<p>Description: 暂停一个job  .</p> 
	 *<p>@param taskJob
	 *<p>@throws SchedulerException void
	 *@since 2015年7月16日: 下午6:58:46
	 *@author xubin
	 *@version 1.0
	 */
	private void pauseJob(TaskJob taskJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(taskJob.getJobName(), taskJob.getJobGroup());
		scheduler.pauseJob(jobKey);
	}
	
	
	@Override
	public int updateRunJobCronExpression(String jobId ,String cronExpression) throws Exception {
		TaskJob job = selectTaskJobById(jobId);
		if (job == null) {
			return 0;
		}
		job.setCronExpression(cronExpression);
		if (TaskJob.JOB_STATUS_RUNNING.equals(job.getJobStatus())) {
			updateRunJobCron(job);
		}
		return updateDataBaseTaskJob(job);
		
	}

	@PostConstruct
	public void init(){
		//Scheduler scheduler = schedulerFactoryBean.getScheduler();
		TaskJob searchCondition =new TaskJob();
		List<TaskJob>  taskJobs=null ;
		 try {
			 //获取数据库中的job
			 taskJobs =selectTaskJobList(searchCondition);
			 for(TaskJob taskJob:taskJobs){
				 insertRunJob(taskJob);
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getRefTaskJob() throws Exception{
		this.init();
	}
	
	/**
	 *<p>Description:添加到内存中job  .</p> 
	 *<p>@param taskJob
	 *<p>@throws SchedulerException void
	 *@since 2015年7月16日: 下午4:52:32
	 *@author xubin
	 *@version 1.0
	 */
	private  void insertRunJob(TaskJob taskJob) throws SchedulerException {
		if (taskJob == null || !TaskJob.JOB_STATUS_RUNNING.equals(taskJob.getJobStatus())) {
			return;
		}
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		TriggerKey triggerKey = TriggerKey.triggerKey(taskJob.getJobName(), taskJob.getJobGroup());
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		// 不存在，创建一个
		if (null == trigger) {
			Class clazz = TaskJob.JOB_STATUC_SYNCHRONOUS.equals(taskJob.getIsConcurrent()) ? QuartzTaskJobFactory.class : QuartzTaskJobFactoryWait.class;

			JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(taskJob.getJobName(), taskJob.getJobGroup()).build();

			jobDetail.getJobDataMap().put("taskJob", taskJob);

			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskJob.getCronExpression());

			trigger = TriggerBuilder.newTrigger().withIdentity(taskJob.getJobName(), taskJob.getJobGroup()).withSchedule(scheduleBuilder).build();

			scheduler.scheduleJob(jobDetail, trigger);
		} else {
			// Trigger已存在，那么更新相应的定时设置
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskJob.getCronExpression());
			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
		}
	}
	
	public int updateRunTaskJob(TaskJob taskJob) throws Exception{
		 TaskJob selecttaskJob =selectTaskJobById( taskJob.getJobId()) ;
		 if( null !=selecttaskJob){
			 if(TaskJob.JOB_STATUS_NOT_RUNNING.equals(selecttaskJob.getJobStatus())){
				 taskJob.setUpdateTime(QuartzUtil.dateUtil.getCurrentTimestamp());
				 validateJobCronExpression(taskJob.getCronExpression());
				 return   taskJobDao.updateStatement("taskJob.updateTaskJob",  taskJob);
			 }else if(TaskJob.JOB_STATUS_RUNNING.equals(selecttaskJob.getJobStatus())) {
				 throw new Exception("当前任务正在启动 请先停止当前任务");
			 }
		 
		 }
		 return 0;
	}

	/**
	 *<p>Description: 更新内存中job表达式  .</p> 
	 *<p>@param taskJob
	 *<p>@throws SchedulerException void
	 *@since 2015年7月16日: 下午4:56:56
	 *@author xubin
	 *@version 1.0
	 */
	private void updateRunJobCron(TaskJob taskJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		TriggerKey triggerKey = TriggerKey.triggerKey(taskJob.getJobName(), taskJob.getJobGroup());
		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(taskJob.getCronExpression());
		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
		scheduler.rescheduleJob(triggerKey, trigger);
	}

	/**
	 *<p>Description:删除内存中的任务  .</p> 
	 *<p>@param taskJob
	 *<p>@throws SchedulerException void
	 *@since 2015年7月16日: 下午4:49:36
	 *@author xubin
	 *@version 1.0
	 */
	private void deleteRunJob(TaskJob taskJob) throws SchedulerException {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(taskJob.getJobName(), taskJob.getJobGroup());
		scheduler.deleteJob(jobKey);
	
	}

	private  void validateJobCronExpression(String cronExpression) throws Exception{
		if(QuartzUtil.stringUtil.isNotBlank(cronExpression)){
			try {
				 CronScheduleBuilder.cronSchedule(cronExpression);
			} catch (Exception e) {
				throw new Exception("CronExpression表达式有误,不能被解析") ;
			}
		}else {
			throw new Exception("CronExpression表达式有误,不允许为null或者空字符串") ;
		}
	}
	
	/**
	 *<p>Description:根据ID查询job  .</p> 
	 *<p>@param taskJobId
	 *<p>@return
	 *<p>@throws Exception TaskJob
	 *@since 2015年7月16日: 下午2:18:45
	 *@author xubin
	 *@version 1.0
	 */
	private TaskJob selectTaskJobById(String taskJobId) throws Exception{
		return taskJobDao.getEntity("taskJob.selectTaskJobById",taskJobId) ;
	}
	/**
     *<p>Description: 分页查询job 查询条件是  and ='' ,page.searchMap.taskJob .</p> 
     *<p>@param page
     *<p>@return
     *<p>@throws Exception Page
     *@since 2015年7月16日: 下午2:18:48
     *@author xubin
     *@version 1.0
     */
	private Page selectTaskJobPage(Page page) throws Exception{
//		List<TaskJob> list = taskJobDao.getEntityList("taskJob.selectTaskJobPage", page);
//        page.setResult(list);
//	    return page;
		return null;
	}
	
	public SchedulerFactoryBean getSchedulerFactoryBean() {
		return schedulerFactoryBean;
	}

	public void setSchedulerFactoryBean(SchedulerFactoryBean schedulerFactoryBean) {
		this.schedulerFactoryBean = schedulerFactoryBean;
	}
	

	public TaskJobDao getTaskJobDao() {
		return taskJobDao;
	}

	public void setTaskJobDao(TaskJobDao taskJobDao) {
		this.taskJobDao = taskJobDao;
	}
	
	
	
	
	
	
}