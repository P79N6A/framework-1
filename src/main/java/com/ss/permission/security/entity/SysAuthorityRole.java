package com.ss.permission.security.entity;

import java.io.Serializable;
import java.util.List;


public class SysAuthorityRole implements Serializable{
	
	private List<SysAuthorityRolesAuthorities> ListSysAuthorityRolesAuthorities;
	
	
	/**  <p>.</p> */
	private static final long serialVersionUID = -3006262120538358219L;
	//columns START
	/**
	 * 
	 */
	private java.lang.String authorityRolesId;
	/**
	 * 
	 */
	private java.lang.String authorityRolesName;
	/**
	 * 
	 */
	private java.lang.String authorityRolesDesc;
	/**
	 * 
	 */
	private java.lang.Boolean authorityRolesIssys;
	/**
	 * 
	 */
	private java.lang.Boolean authorityRolesEnabled;
	//columns END

	public void setAuthorityRolesId(java.lang.String value) {
		this.authorityRolesId = value;
	}
	
	public java.lang.String getAuthorityRolesId() {
		return this.authorityRolesId;
	}
	public void setAuthorityRolesName(java.lang.String value) {
		this.authorityRolesName = value;
	}
	
	public java.lang.String getAuthorityRolesName() {
		return this.authorityRolesName;
	}
	public void setAuthorityRolesDesc(java.lang.String value) {
		this.authorityRolesDesc = value;
	}
	
	public java.lang.String getAuthorityRolesDesc() {
		return this.authorityRolesDesc;
	}
	public void setAuthorityRolesIssys(java.lang.Boolean value) {
		this.authorityRolesIssys = value;
	}
	
	public java.lang.Boolean getAuthorityRolesIssys() {
		return this.authorityRolesIssys;
	}
	public void setAuthorityRolesEnabled(java.lang.Boolean value) {
		this.authorityRolesEnabled = value;
	}
	
	public java.lang.Boolean getAuthorityRolesEnabled() {
		return this.authorityRolesEnabled;
	}

	public List<SysAuthorityRolesAuthorities> getListSysAuthorityRolesAuthorities() {
		return ListSysAuthorityRolesAuthorities;
	}

	public void setListSysAuthorityRolesAuthorities(
			List<SysAuthorityRolesAuthorities> listSysAuthorityRolesAuthorities) {
		ListSysAuthorityRolesAuthorities = listSysAuthorityRolesAuthorities;
	}



}
