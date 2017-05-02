/**  <p>.</p> */
package com.ss.permission.shiro.impl;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;

import com.framework.orm.mybatis.interceptor.PageInterceptor;
import com.ss.permission.shiro.IPermissionService;

/**
 * <p> PermisssionService.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年2月7日: 上午11:27:09
 */
public abstract  class PermisssionService implements IPermissionService {
	
	private static Log log = LogFactory.getLog(PageInterceptor.class);
	
	 @Autowired
     private ShiroFilterFactoryBean shiroFilterFactoryBean;
	 
	 private String iniConfig="";

	/**
	 * @see com.framework.permission.shiro.IPermissionService#initPermissionResource()
	 */
	
	@PostConstruct
	@Override
	public void initPermissionResource() {
		Ini ini  = new Ini();
		// 加载资源文件 
		ini.load(iniConfig);
		 //使用默认节点
		Section section  =ini.getSection("urls");
		
		Map<String, String> permissionMap =initOtherPermissionResource();
		if (permissionMap != null && !permissionMap.isEmpty()) {  
            section.putAll(permissionMap);  
        }  
       
		// TODO Auto-generated method stub

	}
	
	private Section obtainPermission(){
		Ini ini = new Ini();  
        ini.load(iniConfig); // 加载资源文件节点串  
        Section section = ini.getSection("urls"); // 使用默认节点  
        if (section.isEmpty()) {  
            section = ini.getSection(Ini.DEFAULT_SECTION_NAME); // 如不存在默认节点切割,则使用空字符转换  
        }  
        Map<String, String> permissionMap = initOtherPermissionResource();  
        if (permissionMap != null && !permissionMap.isEmpty()) {  
            section.putAll(permissionMap);  
        }  
        return section;  
	}

	/**
	 * @see com.framework.permission.shiro.IPermissionService#updatePermissionResource()
	 */
	@Override
	public void updatePermissionResource() {
		synchronized (shiroFilterFactoryBean) {
			AbstractShiroFilter shiroFilter = null;
			try {
				shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean
						.getObject();
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			// 获取过滤管理器
			PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter
					.getFilterChainResolver();

			DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver
					.getFilterChainManager();

			// 清空初始权限配置
			manager.getFilterChains().clear();
			shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();
			// 重新构建生成
			shiroFilterFactoryBean.setFilterChainDefinitions(iniConfig);
			Map<String, String> chains = shiroFilterFactoryBean
					.getFilterChainDefinitionMap();

			for (Map.Entry<String, String> entry : chains.entrySet()) {
				String url = entry.getKey();
				String chainDefinition = entry.getValue().trim()
						.replace(" ", "");
				manager.createChain(url, chainDefinition);
			}

			log.debug("update shiro permission success...");
		}
	}

	/**
	 * @see com.framework.permission.shiro.IPermissionService#initOtherPermissionResource()
	 */
	public abstract Map<String, String> initOtherPermissionResource();

}
