/**  <p>.</p> */
package com.ss.permission.security.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ss.permission.security.exception.SecurityAuthenticationException;

/**
 * <p> SecurityUsernamePasswordAuthenticationFilter.java.</p>
 * <p>Description: .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Sep 17, 2014: 4:54:03 PM
 */
public class SecurityUsernamePasswordAuthenticationFilter extends
		UsernamePasswordAuthenticationFilter {

	//验证码字段
	private String validateCodeParameter = "validateCode";
	public String getValidateCodeParameter() {
		return validateCodeParameter;
	}
	public void setValidateCodeParameter(String validateCodeParameter) {
		this.validateCodeParameter = validateCodeParameter;
	}

	//是否开启验证码功能
	private boolean openValidateCode = false;
	public boolean isOpenValidateCode() {
		return openValidateCode;
	}
	public void setOpenValidateCode(boolean openValidateCode) {
		this.openValidateCode = openValidateCode;
	}
	/**
	 * login 
	 *(non-Javadoc)
	 * @see org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter#attemptAuthentication(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		if(!"POST".equals(request.getMethod())){
			throw new SecurityAuthenticationException("不支持非POST方式的请求!");
		}
		if(isOpenValidateCode()){
			
		}
				// 获取Username和Password
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		// UsernamePasswordAuthenticationToken实现Authentication校验
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
				username, password);
		setDetails(request, authRequest);
		// user
		return this.getAuthenticationManager().authenticate(authRequest);

	
	}
	
	// 匹对验证码的正确性
	public void checkValidateCode(HttpServletRequest request) {

//		String jcaptchaCode = obtainValidateCodeParameter(request);
//		if (null == jcaptchaCode)
//			throw new SecurityAuthenticationException("验证码超时,请重新获取!");
//
//		boolean b = CaptchaServiceSingleton.getInstance().validateResponseForID(request.getSession().getId(),
//						jcaptchaCode);
//		if (!b)
//			throw new SecurityAuthenticationException("验证码不正确,请重新输入!");
	}
	
//	private  String obtainValidateCodeParameter(HttpServletRequest request) {
//		Object obj = request.getParameter(getValidateCodeParameter());
//		return null == obj ? "" : obj.toString().trim();
//	}

}
