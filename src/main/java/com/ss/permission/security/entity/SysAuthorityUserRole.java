package com.ss.permission.security.entity;

import java.io.Serializable;


public class SysAuthorityUserRole implements Serializable {
	
	
	/**  <p>.</p> */
	private static final long serialVersionUID = 8958460067141905228L;
	//columns START
	/**
	 * 
	 */
	private java.lang.String authorityUserRoleId;
	/**
	 * 
	 */
	private java.lang.String authorityUserId;
	/**
	 * 
	 */
	private java.lang.String authorityRolesId;
	
	
	//columns END
	
	private SysAuthorityRole sysAuthorityRoles;
	
	private SysAuthorityUser sysAuthorityUser;
	
	public SysAuthorityUser getSysAuthorityUser() {
		return sysAuthorityUser;
	}

	public void setSysAuthorityUser(SysAuthorityUser sysAuthorityUser) {
		this.sysAuthorityUser = sysAuthorityUser;
	}

	public SysAuthorityRole getSysAuthorityRoles() {
		return sysAuthorityRoles;
	}

	public void setSysAuthorityRoles(SysAuthorityRole sysAuthorityRoles) {
		this.sysAuthorityRoles = sysAuthorityRoles;
	}

	public void setAuthorityUserRoleId(java.lang.String value) {
		this.authorityUserRoleId = value;
	}
	
	public java.lang.String getAuthorityUserRoleId() {
		return this.authorityUserRoleId;
	}
	public void setAuthorityUserId(java.lang.String value) {
		this.authorityUserId = value;
	}
	
	public java.lang.String getAuthorityUserId() {
		return this.authorityUserId;
	}
	public void setAuthorityRolesId(java.lang.String value) {
		this.authorityRolesId = value;
	}
	
	public java.lang.String getAuthorityRolesId() {
		return this.authorityRolesId;
	}



}
