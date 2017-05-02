package com.ss.permission.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;


/**
 * <p> LoginFailureHandler.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Sep 18, 2014: 2:45:39 PM
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	private String loginFailedUrl ;

	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
//		response.setContentType("text/plain");
//		response.setCharacterEncoding("UTF-8");
		if (ex instanceof UsernameNotFoundException) {
			// 账号错误
			//response.getWriter().print(ex.getMessage());
			request.getSession().setAttribute("ERROR", "001");
		} else if (ex instanceof BadCredentialsException) {
			// 密码错误
			request.getSession().setAttribute("ERROR", "login.error.badcredentialsexception");
			
			//response.getWriter().print("用户/密码错误,请重新输入!");
		} /**else if (ex instanceof ValidateCodeException) {
			// 验证码错误
			response.getWriter().print(ex.getMessage());
		} else if (ex instanceof MethodErrorException) {
			// 请求方法错误
			response.getWriter().print(ex.getMessage());
		} **/
		else if (ex instanceof SessionAuthenticationException) {
			// 登陆超时错误
			response.sendRedirect(request.getContextPath() + "/server/error/timeout.jsp");
		} else {
			// 未知异常错误
			response.getWriter().print("未知异常错误,请联系相关技术人员!");
		}
	}

	public String getLoginFailedUrl() {
		return loginFailedUrl;
	}

	public void setLoginFailedUrl(String loginFailedUrl) {
		this.loginFailedUrl = loginFailedUrl;
	}
}
