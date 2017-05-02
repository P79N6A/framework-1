/**  <p>.</p> */
package com.ss.permission.shiro.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

/**
 * <p> RoleAuthorizationFilter.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年4月13日: 下午1:55:18
 */
public class RoleAuthorizationFilter extends AuthorizationFilter {

	/**
	 * @see org.apache.shiro.web.filter.AccessControlFilter#isAccessAllowed(javax.servlet.ServletRequest, javax.servlet.ServletResponse, java.lang.Object)
	 */
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mapObject) throws Exception {
		Subject subject = super.getSubject(request, response);
		String[] roleArray = (String[]) mapObject;
		if(null==roleArray || roleArray.length==0){
			return true;
		}
		Set<String> roles = CollectionUtils.asSet(roleArray);
		for(String role:roles){
			if(subject.hasRole(role)){
				return true;
			}
		}
		return false;
	}
	@Override
	protected boolean onAccessDenied(ServletRequest request,ServletResponse response)  throws IOException{
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		Subject subject = getSubject(request, response);
		return false;
		
	}

}
