package com.framework.dto;

import java.io.Serializable;

public class BaseDto implements Serializable {
	/**  <p>.</p> */
	private static final long serialVersionUID = 1L;
	String sessionId;
	boolean success;
	String message;
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

}
