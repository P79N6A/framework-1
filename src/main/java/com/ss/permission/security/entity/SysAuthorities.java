package com.ss.permission.security.entity;

import java.io.Serializable;

public class SysAuthorities implements Serializable  {
	
	
	/**  <p>.</p> */
	private static final long serialVersionUID = -4886875821862430199L;
	//columns START
	/**
	 * Ȩ
	 */
	private java.lang.String authoritiesId;
	/**
	 * Ȩ
	 */
	private java.lang.String authoritiesName;
	/**
	 * Ȩ
	 */
	private java.lang.String authoritiesDesc;
	/**
	 * 
	 */
	private java.lang.Boolean authoritiesIssys;
	/**
	 * 
	 */
	private java.lang.Boolean authoritiesEnabled;
	//columns END

	public void setAuthoritiesId(java.lang.String value) {
		this.authoritiesId = value;
	}
	
	public java.lang.String getAuthoritiesId() {
		return this.authoritiesId;
	}
	public void setAuthoritiesName(java.lang.String value) {
		this.authoritiesName = value;
	}
	
	public java.lang.String getAuthoritiesName() {
		return this.authoritiesName;
	}
	public void setAuthoritiesDesc(java.lang.String value) {
		this.authoritiesDesc = value;
	}
	
	public java.lang.String getAuthoritiesDesc() {
		return this.authoritiesDesc;
	}
	public void setAuthoritiesIssys(java.lang.Boolean value) {
		this.authoritiesIssys = value;
	}
	
	public java.lang.Boolean getAuthoritiesIssys() {
		return this.authoritiesIssys;
	}
	public void setAuthoritiesEnabled(java.lang.Boolean value) {
		this.authoritiesEnabled = value;
	}
	
	public java.lang.Boolean getAuthoritiesEnabled() {
		return this.authoritiesEnabled;
	}



}
