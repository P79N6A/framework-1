/**  <p>.</p> */
package com.ss.quartz.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * <p> SpringQuartzUtil.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月15日: 下午2:08:55
 */
public class SpringQuartzUtil implements BeanFactoryPostProcessor {
	
	private static ConfigurableListableBeanFactory beanFactory;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0)
			throws BeansException {
	
		beanFactory=arg0;
	}
	
	public static <T>  Object getBean(String name) throws BeansException {
		return  beanFactory.getBean(name);
	}
	

}
