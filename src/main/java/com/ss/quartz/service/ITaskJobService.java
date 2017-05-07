package com.ss.quartz.service;


import java.util.List;

import com.ss.quartz.entity.TaskJob;

public interface ITaskJobService {
	
	/**
	 *<p>Description: 数据库添加job 包含字段  jobName jobGroup cronExpression springId methodName 默认状态是未启动.</p> 
	 *<p>@param taskJob
	 *<p>@throws Exception void
	 *@since 2015年7月16日: 下午2:18:38
	 *@author xubin
	 *@version 1.0
	 */
	String insertDataBaseTaskJob(TaskJob taskJob) throws Exception;
	
	public void getRefTaskJob() throws Exception;
	
	/**
	 *<p>Description:根据ID删除 job 所有启动状态的都不允许删除   .</p> 
	 *<p>@param taskJob
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2015年7月16日: 下午2:18:42
	 *@author xubin
	 *@version 1.0
	 */
	int deleteDataBaseTaskJobById(TaskJob taskJob) throws Exception;
	
	/**
	 *<p>Description:返回所有的job不分页   .</p> 
	 *<p>@param searchCondition
	 *<p>@return
	 *<p>@throws Exception List<TaskJob>
	 *@since 2015年7月16日: 下午2:18:51
	 *@author xubin
	 *@version 1.0
	 */
	List<TaskJob> selectTaskJobList (TaskJob searchCondition) throws Exception;
	
	/**
	 *<p>Description:启动和停止  .</p> 
	 *<p>@param taskJob
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2015年7月16日: 下午2:18:35
	 *@author xubin
	 *@version 1.0
	 */
	int updateRunJobStatus(String jobId,String cmd) throws Exception;
	/**
	 *<p>Description: 更新表达式 .</p> 
	 *<p>@param taskJob
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2015年7月16日: 下午5:23:46
	 *@author xubin
	 *@version 1.0
	 */
	int updateRunJobCronExpression(String jobId ,String cronExpression)  throws Exception;
	
	/**
	 *<p>Description:更新  taskJob 只有启动状态的才能更新.</p> 
	 *<p>@param taskJob
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2015年7月16日: 下午6:10:41
	 *@author xubin
	 *@version 1.0
	 */
	int updateRunTaskJob(TaskJob taskJob) throws Exception;
	

}