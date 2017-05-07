/**  <p>.</p> */
package com.ss.quartz.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ss.quartz.entity.TaskJob;
import com.ss.quartz.service.ITaskJobService;

/**
 * <p> TaskJobController.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月20日: 上午9:27:29
 */
@RestController
public class TaskJobController {

	public final Logger log = Logger.getLogger(this.getClass());
    @Autowired
	private ITaskJobService taskJobService;

	public ITaskJobService getTaskJobService() {
		return taskJobService;
	}

	public void setTaskJobService(ITaskJobService taskJobService) {
		this.taskJobService = taskJobService;
	}
	
	/**
	 *<p>Description:查询taskjob 列表  .</p> 
	 *<p>@return
	 *<p>@throws Exception List<TaskJob>
	 *@since 2015年7月20日: 上午10:13:50
	 *@author xubin
	 *@version 1.0
	 */
	@RequestMapping(value="taskJobList",method=RequestMethod.GET)
	public List<TaskJob> taskList() throws Exception{
		TaskJob  searchCondition =new TaskJob();
		return taskJobService.selectTaskJobList(searchCondition) ;
	}
	/**
	 *<p>Description: 添加task job.</p> 
	 *<p>@param taskJob
	 *<p>@throws Exception void
	 *@since 2015年7月20日: 上午10:14:09
	 *@author xubin
	 *@version 1.0
	 */
	@RequestMapping(value="addTaskJob",method=RequestMethod.GET)
	public String  addTaskJob(@RequestBody TaskJob taskJob) throws Exception {
		return taskJobService.insertDataBaseTaskJob(taskJob) ;
	}
	/**
	 *<p>Description: 停止任务 .</p> 
	 *<p>@param jobId
	 *<p>@param cmd
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2015年7月20日: 上午10:42:45
	 *@author xubin
	 *@version 1.0
	 */
	@RequestMapping(value="stopTaskJob/{jobId}/{cmd}",method=RequestMethod.GET)
	public int  stopTaskJob(@PathVariable String jobId,@PathVariable String cmd)  throws Exception{
		return taskJobService.updateRunJobStatus(jobId, "stop");
	}
	/**
	 *<p>Description:启动任务  .</p> 
	 *<p>@param jobId
	 *<p>@param cmd
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2015年7月20日: 上午10:43:07
	 *@author xubin
	 *@version 1.0
	 */
	@RequestMapping(value="startTaskJob/{jobId}/{cmd}",method=RequestMethod.GET)
	public int  startTaskJob(@PathVariable String jobId,@PathVariable String cmd) throws Exception {
		return taskJobService.updateRunJobStatus(jobId, "start");
	}
	
	public void runTaskJob() throws Exception{
		
	}
	
	

}
