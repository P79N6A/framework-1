/**  <p>.</p> */
package com.framework.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p> SpringBeanUtil.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Nov 17, 2014: 6:12:54 PM
 */
public class SpringBeanUtil {
	
	private static ApplicationContext wac = null;
    private static String configLocation = "classpath:spring-context.xml";
	
	/**
	 * 根据spring bean配置文件中的bean id获得bean的实例
	 * @param beanID
	 * @return
	 */
	public static final Object getBean(String beanID) {
		if (getWac() != null)
			return getWac().getBean(beanID);
		else 
			return null;
	}
	public static ApplicationContext getWac() {
		if (wac == null) {
			wac =  new ClassPathXmlApplicationContext(configLocation);
		}

		return wac;
	}

	

}
