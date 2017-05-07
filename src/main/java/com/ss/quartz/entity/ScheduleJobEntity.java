/**  <p>.</p> */
package com.ss.quartz.entity;

import java.io.Serializable;

/**
 * <p> ScheduleJobEntity.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月14日: 下午5:11:18
 */
public class ScheduleJobEntity implements Serializable {
	
	public static final String STATUS_RUNNING = "1";  
    public static final String STATUS_NOT_RUNNING = "0";  

	/**  <p>.</p> */
	private static final long serialVersionUID = -8149892636986721677L;
	
	/**  <p>任务ID.</p> */
	private String id;
	
	/**  <p>任务名称 .</p> */
	private String name;
	/**  <p>任务分组 .</p> */
	private String group;
	
	/**  <p>cron表达式 .</p> */
	private String cronExpression;
	
	/**  <p>任务描述.</p> */
	private String description;
	
	/**  <p>.</p> */
	private String jobStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobStatus() {
		return jobStatus;
	}

	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}

}
