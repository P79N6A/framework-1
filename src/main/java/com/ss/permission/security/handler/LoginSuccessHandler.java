/**  <p>.</p> */
package com.ss.permission.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ss.permission.security.entity.SysAuthorityUser;
import com.ss.permission.security.utils.SecurtityUtils;

/**
 * <p> LoginSuccessHandler.java.</p>
 * <p>Description:login success handler  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Sep 18, 2014: 1:36:22 PM
 */

public class LoginSuccessHandler  implements
		AuthenticationSuccessHandler {
	
	private String indexSucessUrl;

	public String getIndexSucessUrl() {
		return indexSucessUrl;
	}

	public void setIndexSucessUrl(String indexSucessUrl) {
		this.indexSucessUrl = indexSucessUrl;
	}

	/**
	 *(non-Javadoc)
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		SysAuthorityUser user = (SysAuthorityUser) SecurtityUtils.getUserDetails();
	    String path = request.getContextPath();
	    String bootPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
	    System.out.print(bootPath);
	    response.sendRedirect(bootPath+indexSucessUrl);
	    response.setContentType("text/plain");
		response.getWriter().print("success");

	}
	
    

}
