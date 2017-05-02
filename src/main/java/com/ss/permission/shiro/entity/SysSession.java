package com.ss.permission.shiro.entity;

import java.io.Serializable;

public class SysSession implements Serializable {
	
	
	/**  <p>.</p> */
	private static final long serialVersionUID = 1152831682100419751L;
	//columns START
	/**
	 * 
	 */
	private java.lang.String sessionId;
	/**
	 * 
	 */
	private java.lang.String session;
	//columns END

	public void setSessionId(java.lang.String value) {
		this.sessionId = value;
	}
	
	public java.lang.String getSessionId() {
		return this.sessionId;
	}
	public void setSession(java.lang.String value) {
		this.session = value;
	}
	
	public java.lang.String getSession() {
		return this.session;
	}



}
