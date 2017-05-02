/**  <p>.</p> */
package com.ss.permission.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <p> SecurityAuthenticationException.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Sep 17, 2014: 4:59:37 PM
 */
public class SecurityAuthenticationException extends AuthenticationException {

	public SecurityAuthenticationException(String msg) {
		super(msg);
		
	}
	
	public SecurityAuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

	/**  <p>.</p> */
	private static final long serialVersionUID = 5461825038109713237L;

}
