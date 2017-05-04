/**  <p>.</p> */
package com.framework.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.framework.dto.AppRequest;
import com.framework.dto.SessionUser;

/**
 * <p> BaseController.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年5月3日: 上午10:18:23
 */
public abstract class BaseController {
	protected Logger logger = Logger.getLogger(this.getClass());
	
	private static Log log = LogFactory.getLog(BaseController.class);
	
	public AppRequest getAppRequest() {

		SessionUser su = getSessionUser();
		if (null != su) {
			return new AppRequest(su, getRequest().getRemoteHost());
		}
		return null;

	}
	
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		
		return request;
	}
	
	public  AppRequest getAppRequestDto(String key){
		AppRequest appRequestDto = getAppRequest();
		if(null !=appRequestDto.getClass() && appRequestDto.getKeys().size()>0){
			appRequestDto.removeAllKey();
		}
		appRequestDto.addKey(key);
		return appRequestDto;
	}
	
	/**
	 *<p>Description:获取session中的 sessionUserDto  .</p> 
	 *<p>@return SessionUserDto
	 *@since 2017年5月3日: 上午11:28:09
	 *@author xubin
	 *@version 1.0
	 */
	public SessionUser getSessionUser(){
		return (SessionUser) getRequest().getSession().getAttribute(getSessionUserKey());
	}
	
	protected String getSessionUserKey() {
		return "com.framework.dto.SessionUserDto";
	}
	
	/**
	 *<p>Description: 设置session中sessionUserDto .</p> 
	 *<p>@param suser void
	 *@since 2017年5月3日: 上午11:28:12
	 *@author xubin
	 *@version 1.0
	 */
	protected void setUserInSession(SessionUser suser) {
		HttpSession session = getRequest().getSession();
		if ((null != session) && (null != suser))
			session.setAttribute(getSessionUserKey(), suser);
	}

}
