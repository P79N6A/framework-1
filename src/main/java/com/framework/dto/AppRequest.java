/**  <p>.</p> */
package com.framework.dto;

import java.util.ArrayList;
import java.util.List;

import com.framework.util.StringUtils;

/**
 * <p> AppRequestDto.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年5月3日: 上午10:27:46
 */
public class AppRequest {
	/**  <p>IP地址.</p> */
	private String ip;
	
	private List<String> keys;
	
	public AppRequest(SessionUser dto,String ip){
		if(null!=dto){
			
		}
		setIp(ip);
		
	}

	/**
	 *<p>Description:  .</p> 
	 *<p>@param newKey void
	 *@since 2017年5月3日: 上午10:36:03
	 *@author xubin
	 *@version 1.0
	 */
	public void addKey(String newKey) {
		if (StringUtils.isBlank(newKey)) {
			this.keys = new ArrayList<String>();
		}
		this.keys.add(newKey);
	}
	
	/**
	 *<p>Description:  .</p> 
	 *<p> void
	 *@since 2017年5月3日: 上午10:51:00
	 *@author xubin
	 *@version 1.0
	 */
	public void removeAllKey(){
		if(null!=this.keys && this.keys.size()>0){
			this.keys.clear();
		}
	}

	public List<String> getKeys() {
		return keys;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
