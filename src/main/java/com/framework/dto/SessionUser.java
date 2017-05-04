package com.framework.dto;

import java.io.Serializable;

import com.framework.util.BeanUtils;

public class SessionUser implements Serializable  {
	
	private String loginName;
	private String userId;
	private boolean locked;
	private String orgId;
	private String stationId;
	

	/**  <p>.</p> */
	private static final long serialVersionUID = 7469122189542547910L;
	
	public SessionUser(Object o) {
		if (o != null)
			try {
				BeanUtils.copyProperties(this, o);
			} catch (Exception e) {
				
			}
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

}
