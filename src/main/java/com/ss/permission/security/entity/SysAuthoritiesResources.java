package com.ss.permission.security.entity;

import java.io.Serializable;


public class SysAuthoritiesResources implements Serializable {
	
	
	/**  <p>.</p> */
	private static final long serialVersionUID = 1787166914959933913L;
	
	private SysAuthorities sysAuthorities;

	private SysAuthorityResources sysAuthorityResources;
	//columns START
	/**
	 * 
	 */
	private java.lang.String authoritiesResourcesId;
	/**
	 * 
	 */
	private java.lang.String authoritiesId;
	/**
	 * 
	 */
	private java.lang.String authorityResourcesId;
	//columns END

	public void setAuthoritiesResourcesId(java.lang.String value) {
		this.authoritiesResourcesId = value;
	}
	
	public java.lang.String getAuthoritiesResourcesId() {
		return this.authoritiesResourcesId;
	}
	public void setAuthoritiesId(java.lang.String value) {
		this.authoritiesId = value;
	}
	
	public java.lang.String getAuthoritiesId() {
		return this.authoritiesId;
	}
	public void setAuthorityResourcesId(java.lang.String value) {
		this.authorityResourcesId = value;
	}
	
	public java.lang.String getAuthorityResourcesId() {
		return this.authorityResourcesId;
	}
	public SysAuthorities getSysAuthorities() {
		return sysAuthorities;
	}

	public void setSysAuthorities(SysAuthorities sysAuthorities) {
		this.sysAuthorities = sysAuthorities;
	}

	public SysAuthorityResources getSysAuthorityResources() {
		return sysAuthorityResources;
	}

	public void setSysAuthorityResources(SysAuthorityResources sysAuthorityResources) {
		this.sysAuthorityResources = sysAuthorityResources;
	}



}
