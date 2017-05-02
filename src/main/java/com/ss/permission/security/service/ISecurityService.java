/**  <p>.</p> */
package com.ss.permission.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

import com.ss.permission.security.entity.SysAuthoritiesResources;
import com.ss.permission.security.entity.SysAuthorityResources;
import com.ss.permission.security.entity.SysAuthorityUser;

/**
 * <p> ISecurityService.java.</p>
 * <p>Description:权限  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Sep 15, 2014: 3:35:26 PM
 */
public interface ISecurityService {
	/**
	 *<p>Description: 获取所有的资源 .</p> 
	 *<p>@return
	 *<p>@throws Exception Map<String,Collection<ConfigAttribute>>
	 *@since Sep 17, 2014: 9:06:34 AM
	 *@author xubin
	 *@version 1.0
	 */
	Map<String, Collection<ConfigAttribute>> getResourcesAuthority()throws Exception;
	/**
	 *<p>Description: 所有的资源对应的权限  .</p> 
	 *<p>@return
	 *<p>@throws Exception List<SysAuthorityResources>
	 *@since Sep 17, 2014: 9:06:37 AM
	 *@author xubin
	 *@version 1.0
	 */
	List<SysAuthorityResources> getAllAuthorityResources() throws Exception;
	
	/**
	 *<p>Description:  .</p> 
	 *<p>@param userName
	 *<p>@return
	 *<p>@throws Exception SysAuthorityUser
	 *@since Sep 18, 2014: 3:51:38 PM
	 *@author xubin
	 *@version 1.0
	 */
	SysAuthorityUser  getSysAuthorityUserByUserName(String userName) throws Exception;
	
	List<SysAuthoritiesResources> getResourcesAuthorityByRoleId(String roleId) throws Exception;
	
	void delete (String table_name,Map<String, Object> map )  throws Exception ;


}
