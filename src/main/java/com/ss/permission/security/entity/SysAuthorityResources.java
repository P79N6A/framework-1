package com.ss.permission.security.entity;

import java.io.Serializable;
import java.util.List;


public class SysAuthorityResources implements Serializable {
	
	
	/**  <p>.</p> */
	private static final long serialVersionUID = -3431225203577918303L;
	
	private List<SysAuthorityRole>  resourcesSysAuthorityRoles;
	public List<SysAuthorityRole> getResourcesSysAuthorityRoles() {
		return resourcesSysAuthorityRoles;
	}

	public void setResourcesSysAuthorityRoles(
			List<SysAuthorityRole> resourcesSysAuthorityRoles) {
		this.resourcesSysAuthorityRoles = resourcesSysAuthorityRoles;
	}

	//columns START
	/**
	 * 
	 */
	private java.lang.String authorityResourcesId;
	/**
	 * 
	 */
	private java.lang.String authorityResourcesName;
	/**
	 * 
	 */
	private java.lang.String authorityResourcesDesc;
	/**
	 * 
	 */
	private java.lang.String authorityResourcesType;
	/**
	 * 
	 */
	private java.lang.Integer authorityResourcesSort;
	/**
	 * 
	 */
	private java.lang.String authorityResourcesUrl;
	/**
	 * 
	 */
	private java.lang.Boolean authorityResourcesIssys;
	/**
	 * 
	 */
	private java.lang.Boolean authorityResourcesEnabled;
	//columns END

	public void setAuthorityResourcesId(java.lang.String value) {
		this.authorityResourcesId = value;
	}
	
	public java.lang.String getAuthorityResourcesId() {
		return this.authorityResourcesId;
	}
	public void setAuthorityResourcesName(java.lang.String value) {
		this.authorityResourcesName = value;
	}
	
	public java.lang.String getAuthorityResourcesName() {
		return this.authorityResourcesName;
	}
	public void setAuthorityResourcesDesc(java.lang.String value) {
		this.authorityResourcesDesc = value;
	}
	
	public java.lang.String getAuthorityResourcesDesc() {
		return this.authorityResourcesDesc;
	}
	public void setAuthorityResourcesType(java.lang.String value) {
		this.authorityResourcesType = value;
	}
	
	public java.lang.String getAuthorityResourcesType() {
		return this.authorityResourcesType;
	}
	public void setAuthorityResourcesSort(java.lang.Integer value) {
		this.authorityResourcesSort = value;
	}
	
	public java.lang.Integer getAuthorityResourcesSort() {
		return this.authorityResourcesSort;
	}
	public void setAuthorityResourcesUrl(java.lang.String value) {
		this.authorityResourcesUrl = value;
	}
	
	public java.lang.String getAuthorityResourcesUrl() {
		return this.authorityResourcesUrl;
	}
	public void setAuthorityResourcesIssys(java.lang.Boolean value) {
		this.authorityResourcesIssys = value;
	}
	
	public java.lang.Boolean getAuthorityResourcesIssys() {
		return this.authorityResourcesIssys;
	}
	public void setAuthorityResourcesEnabled(java.lang.Boolean value) {
		this.authorityResourcesEnabled = value;
	}
	
	public java.lang.Boolean getAuthorityResourcesEnabled() {
		return this.authorityResourcesEnabled;
	}



}
