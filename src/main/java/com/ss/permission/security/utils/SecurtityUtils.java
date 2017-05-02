/**  <p>.</p> */
package com.ss.permission.security.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ss.permission.security.entity.SysAuthorityUser;

/**
 * <p> SecurtityUtils.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Sep 18, 2014: 1:40:55 PM
 */
public abstract class SecurtityUtils {
	
	private final  static String SPRING_SECURITY_CONTEXT="SPRING_SECURITY_CONTEXT";
	
	public SecurityContext getSecurityContext(){
		return (SecurityContext) getSession().getAttribute(SPRING_SECURITY_CONTEXT);
	}
	
	public static  Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	
	/**
	 * 获取SECURITY3的认证对象
	 * 
	 * @return UserDetails
	 */
	public static  SysAuthorityUser getUserDetails() {
		return (SysAuthorityUser) getAuthentication().getPrincipal();
	}

	
	/**
	 * 获取HttpSession实例
	 * 
	 * @return HttpSession
	 */
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
	/**
	 * 获取HttpServletRequest实例
	 * 
	 * @return HttpServletRequest
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = requestHook();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		return request;
	}
	
	/**
	 * request初始化钩子
	 * 
	 * @return HttpServletRequest
	 */
	public HttpServletRequest requestHook() {
		return null;
	}

	/**
	 * response初始化钩子
	 * 
	 * @return HttpServletResponse
	 */
	public HttpServletResponse responseHook() {
		return null;
	}

}
