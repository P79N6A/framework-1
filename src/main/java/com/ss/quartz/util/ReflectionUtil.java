/**  <p>.</p> */
package com.ss.quartz.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.ss.quartz.entity.TaskJob;

/**
 * <p> ReflectionUtil.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月16日: 上午10:41:37
 */
public  class ReflectionUtil {
	
	public final static Logger log = Logger.getLogger(ReflectionUtil.class);
	
	ReflectionUtil() {

	}

	public void invokMethod(TaskJob taskJob) {
		Object object = null;
		Class<?> clazz = null;
		if(QuartzUtil.stringUtil.isNotBlank(taskJob.getSpringId())){
			object=SpringQuartzUtil.getBean(taskJob.getSpringId());
		}else if(QuartzUtil.stringUtil.isNotBlank(taskJob.getBeanClass())){
			try {
				clazz=Class.forName(taskJob.getBeanClass()) ;
			} catch (ClassNotFoundException e) {
				log.error(""+taskJob.getBeanClass()+" is not found !" +e.getCause());
			}
		}
		
		if (null == object) {
			log.error("任务名称 = [" + taskJob.getJobName() + "]---------------未启动成功，请检查是否配置正确！！！");
			return;
		}
		
		clazz = object.getClass();
		Method method = null;
		try {
			method=clazz.getDeclaredMethod(taskJob.getMethodName()) ;
		} catch (NoSuchMethodException e) {
			log.error("任务名称 = [" + taskJob.getJobName() + "]---------------未启动成功,"+"["+clazz+taskJob.getMethodName()+"]"+"方法名设置错误！！！");
		} catch (SecurityException e) {
			log.error("任务名称 = [" + taskJob.getJobName() + "]---------------未启动成功,"+"["+clazz+taskJob.getMethodName()+"]"+"方法名设置错误！！！"+e.getCause());
		}
		
		if(null!=method) {
			try {
				method.invoke(object);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.info("任务名称 = [" + taskJob.getJobName() + "]=>"+"["+clazz+taskJob.getMethodName()+"]"+"启动成功");
	}

}
