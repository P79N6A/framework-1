/**  <p>.</p> */
package com.ss.permission.shiro;

import java.util.Map;

/**
 * <p> FilterChainDefinitionsService.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年2月7日: 上午11:19:28
 */
public interface IPermissionService {
	public static final String PREMISSION_STRING = "perms[{0}]"; // 资源结构格式  
    public static final String ROLE_STRING = "role[{0}]"; // 角色结构格式  
	
	/**
	 *<p>Description:初始化权限资源  .</p> 
	 *<p> void
	 *@since 2015年2月7日: 上午11:21:57
	 *@author xubin
	 *@version 1.0
	 */
	public abstract void  initPermissionResource();
	
	/**
	 *<p>Description:更新权限资源 强制线程同步  .</p> 
	 *<p> void
	 *@since 2015年2月7日: 上午11:22:54
	 *@author xubin
	 *@version 1.0
	 */
	public abstract void updatePermissionResource();
	
	/**
	 *<p>Description:初始化第三方权限  .</p> 
	 *<p>@return Map<String,Object>
	 *@since 2015年2月7日: 上午11:25:10
	 *@author xubin
	 *@version 1.0
	 */
	public abstract Map<String, String> initOtherPermissionResource();

}
