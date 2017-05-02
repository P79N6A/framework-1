package com.ss.permission.security.entity;

import java.io.Serializable;


public class SysAuthorityRolesAuthorities implements Serializable{
	
	
	/**  <p>.</p> */
	private static final long serialVersionUID = 9085367822043490340L;
	//columns START
	/**
	 * 
	 */
	private java.lang.String authorityRolesAuthoritiesId;
	/**
	 * 
	 */
	private java.lang.String authorityRolesId;
	/**
	 * Ȩ
	 */
	private java.lang.String authoritiesId;
	//columns END

	public void setAuthorityRolesAuthoritiesId(java.lang.String value) {
		this.authorityRolesAuthoritiesId = value;
	}
	
	public java.lang.String getAuthorityRolesAuthoritiesId() {
		return this.authorityRolesAuthoritiesId;
	}
	public void setAuthorityRolesId(java.lang.String value) {
		this.authorityRolesId = value;
	}
	
	public java.lang.String getAuthorityRolesId() {
		return this.authorityRolesId;
	}
	public void setAuthoritiesId(java.lang.String value) {
		this.authoritiesId = value;
	}
	
	public java.lang.String getAuthoritiesId() {
		return this.authoritiesId;
	}



}
