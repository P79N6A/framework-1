/**  <p>.</p> */
package com.ss.quartz.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.ss.quartz.entity.ScheduleJobEntity;

/**
 * <p> ScheduleJobDao.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月14日: 下午5:27:57
 */
public class ScheduleJobDao {
	
	 private JdbcTemplate jdbcTemplate;
	 
	 //简化插入数据操作  
     private SimpleJdbcInsert inserActor;
	 
	 public void insertJob(ScheduleJobEntity jobEntity) throws Exception{
		 Map<String,Object> parameters = new HashMap<String,Object>();  
		 parameters.put("", jobEntity.getId());
		 parameters.put("", jobEntity.getName());
		 parameters.put("", jobEntity.getGroup());
		 parameters.put("", jobEntity.getCronExpression());
		 
		 parameters.put("", jobEntity.getDescription());
		 parameters.put("", jobEntity.getJobStatus());
		 inserActor.executeAndReturnKey(parameters) ;
	 }

}
