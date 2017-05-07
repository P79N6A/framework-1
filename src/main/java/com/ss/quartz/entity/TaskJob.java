package com.ss.quartz.entity;

import java.io.Serializable;

public class TaskJob implements Serializable {
	
	/**  <p>启动任务.</p> */
	public static final String JOB_STATUS_RUNNING = "1";
	public static final String JOB_STATUS_NOT_RUNNING = "0";
	
	public static final String JOB_STATUC_SYNCHRONOUS = "1";
	public static final String JOB_STATUC_NOT_SYNCHRONOUS = "0";
	
	
	
	public TaskJob(String jobName,String jobGroup,String cronExpression,String springId,String methodName ){
		this.jobName =jobName;
		this.jobGroup =jobGroup;
		this.cronExpression =cronExpression;
		this.springId=springId;
		this.methodName =methodName;
		
	}
	
	/**用来查询是否重复
	 * @param jobName
	 * @param jobGroup
	 */
	public TaskJob(String jobName,String jobGroup){
		
	}
	public TaskJob(){
		
	}
	
	/**  <p>.</p> */
	private static final long serialVersionUID = 338181557301488935L;
	//columns START
	/**
	 * 
	 */
	private java.lang.String jobId;
	/**
	 * 
	 */
	private java.sql.Timestamp createTime;
	/**
	 * 
	 */
	private java.sql.Timestamp updateTime;
	/**
	 * 
	 */
	private java.lang.String jobName;
	/**
	 * 
	 */
	private java.lang.String jobGroup;
	/**
	 * 
	 */
	private java.lang.String jobStatus;
	/**
	 * 
	 */
	private java.lang.String cronExpression;
	/**
	 * 
	 */
	private java.lang.String description;
	/**
	 * 
	 */
	private java.lang.String beanClass;
	/**
	 * 1
	 */
	private java.lang.String isConcurrent;
	/**
	 * 
	 */
	private java.lang.String springId;
	/**
	 * 
	 */
	private java.lang.String methodName;
	//columns END

	public void setJobId(java.lang.String value) {
		this.jobId = value;
	}
	
	public java.lang.String getJobId() {
		return this.jobId;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}
	public void setUpdateTime(java.sql.Timestamp value) {
		this.updateTime = value;
	}
	
	public java.sql.Timestamp getUpdateTime() {
		return this.updateTime;
	}
	public void setJobName(java.lang.String value) {
		this.jobName = value;
	}
	
	public java.lang.String getJobName() {
		return this.jobName;
	}
	public void setJobGroup(java.lang.String value) {
		this.jobGroup = value;
	}
	
	public java.lang.String getJobGroup() {
		return this.jobGroup;
	}
	public void setJobStatus(java.lang.String value) {
		this.jobStatus = value;
	}
	
	public java.lang.String getJobStatus() {
		return this.jobStatus;
	}
	public void setCronExpression(java.lang.String value) {
		this.cronExpression = value;
	}
	
	public java.lang.String getCronExpression() {
		return this.cronExpression;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	public void setBeanClass(java.lang.String value) {
		this.beanClass = value;
	}
	
	public java.lang.String getBeanClass() {
		return this.beanClass;
	}
	public void setIsConcurrent(java.lang.String value) {
		this.isConcurrent = value;
	}
	
	public java.lang.String getIsConcurrent() {
		return this.isConcurrent;
	}
	public void setSpringId(java.lang.String value) {
		this.springId = value;
	}
	
	public java.lang.String getSpringId() {
		return this.springId;
	}
	public void setMethodName(java.lang.String value) {
		this.methodName = value;
	}
	
	public java.lang.String getMethodName() {
		return this.methodName;
	}



}
