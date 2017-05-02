package com.ss.permission.security.entity;

import java.io.Serializable;
import java.util.List;



/**
 * <p> SysAuthorityUser.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2014-8-18: 下午5:28:39
 */
public  class SysAuthorityUser extends BaseUserDetailsEntity implements Serializable  {
	
	
	
	/**  <p>.</p> */
	private static final long serialVersionUID = -7741525573036264357L;
	/**  <p>.</p> */
	private String authorityUserId;
	
	/**  <p>.</p> */
	private String authorityUserName;
	/**
	 * 
	 */
	private String authorityUserDesc;
	/**
	 * 
	 */
	private Boolean authorityUserIssys;
	/**
	 * 
	 */
	private Boolean authoorityUserEnabled;
	
	List<SysAuthorityUserRole> sysAuthorityUserRoles;
	
	public SysAuthorityUser(){
		
	}
	public List<SysAuthorityUserRole> getSysAuthorityUserRoles() {
		return sysAuthorityUserRoles;
	}

	public void setSysAuthorityUserRoles(
			List<SysAuthorityUserRole> sysAuthorityUserRoles) {
		this.sysAuthorityUserRoles = sysAuthorityUserRoles;
	}

	public void setAuthorityUserId(String value) {
		this.authorityUserId = value;
	}
	
	public String getAuthorityUserId() {
		return this.authorityUserId;
	}

	public void setAuthorityUserDesc(String value) {
		this.authorityUserDesc = value;
	}
	
	public String getAuthorityUserDesc() {
		return this.authorityUserDesc;
	}
	public void setAuthorityUserIssys(Boolean value) {
		this.authorityUserIssys = value;
	}
	
	public Boolean getAuthorityUserIssys() {
		return this.authorityUserIssys;
	}
	public void setAuthoorityUserEnabled(Boolean value) {
		this.authoorityUserEnabled = value;
	}
	
	public Boolean getAuthoorityUserEnabled() {
		return this.authoorityUserEnabled;
	}
    /**=================== **/
	public String getAuthorityUserName() {
		return authorityUserName;
	}
	public void setAuthorityUserName(String authorityUserName) {
		this.authorityUserName = authorityUserName;
	}
	
	


}
