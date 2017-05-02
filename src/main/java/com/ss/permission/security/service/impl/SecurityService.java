package com.ss.permission.security.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;

import com.ss.permission.security.dao.AuthoritiesResourcesDao;
import com.ss.permission.security.dao.AuthorityResourcesDao;
import com.ss.permission.security.dao.AuthorityUserDao;
import com.ss.permission.security.entity.SysAuthoritiesResources;
import com.ss.permission.security.entity.SysAuthorityResources;
import com.ss.permission.security.entity.SysAuthorityUser;
import com.ss.permission.security.service.ISecurityService;

@Service
public class SecurityService implements ISecurityService {
	@Autowired
	private AuthorityResourcesDao authorityResourcesDao;
	@Autowired
	private AuthoritiesResourcesDao authoritiesResourcesDao;
	@Autowired
	private AuthorityUserDao authorityUserDao ;
	
	/**
	 *(non-Javadoc)
	 * @see com.framework.securty.service.ISecurityService#getAllAuthorityResources()
	 */
	@Override
	public List<SysAuthorityResources> getAllAuthorityResources() throws Exception {
		return  authorityResourcesDao.getEntityList("security.getSysAuthorityResourcesList", null) ;
	}
	/**
	 *(non-Javadoc)
	 * @see com.framework.securty.service.ISecurityService#getResourcesAuthority()
	 */
	@Override
    public  Map<String, Collection<ConfigAttribute>> getResourcesAuthority() throws Exception{
		Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
		List<SysAuthoritiesResources> list = authoritiesResourcesDao.getEntityList("security.getAllResourcesAuthority", null);
		Collection<ConfigAttribute> value = null;
		ConfigAttribute configAttribute = null;
		String auth =null;
		for (SysAuthoritiesResources sysAuthoritiesResources : list) {
			String key = sysAuthoritiesResources.getSysAuthorityResources().getAuthorityResourcesUrl();
			if (null != sysAuthoritiesResources.getSysAuthorities()) {
				//ROLE_
				auth = ""+sysAuthoritiesResources.getSysAuthorities().getAuthoritiesName();
				
			}else{
				auth="ANMINISTRATOR";
			}
			configAttribute = new SecurityConfig(auth);
			if (resourceMap.containsKey(key)) {
				value = resourceMap.get(key);
			} else {
				value = new ArrayList<ConfigAttribute>();
			}
			value.add(configAttribute);
			resourceMap.put(key, value);
		}
//		synchronized (resourceMap) {
//			for(String url:resourceMap.keySet()){
//				Iterator<ConfigAttribute> it = resourceMap.get(url).iterator();
//				while(it.hasNext()){
//					ConfigAttribute attribute=it.next();
//					if(!(attribute.getAttribute().indexOf("ANMINISTRATOR")==-1)){
//						System.out.println(""+attribute.getAttribute()+attribute.getAttribute().indexOf("ANMINISTRATOR"));
//						it.remove();
//						it.;
//					}
//				}
//				for (Iterator<ConfigAttribute> it = configAttributes.iterator();it.hasNext();){    //reparations为Collection  
//					ConfigAttribute attribute =it.next();  
//					if(!(attribute.getAttribute().indexOf("ANMINISTRATOR")>-1)){
//						configAttributes.add(new SecurityConfig("ANMINISTRATOR"));
//					}
//			    }  
//				
//			}
//		}
		return resourceMap;
    }
	/**
	 *(non-Javadoc)
	 * @see com.framework.securty.service.ISecurityService#getSysAuthorityUserByUserName(java.lang.String)
	 */
	@Override
	public SysAuthorityUser  getSysAuthorityUserByUserName(String userName) throws Exception{
		SysAuthorityUser sysAuthorityUsers  =authorityUserDao.getEntity("security.getSysAuthorityUserByUserName", userName);
		return sysAuthorityUsers;
		
	}
	@Override
	public void delete (String table_name,Map<String, Object> map )  throws Exception {
		authorityUserDao.deleteEntityById(table_name, map);
	}
//	@Override
//	public SysAuthorityRole getSysAuthorityRoleByRoleId(String authorityRolesId)
//			throws Exception {
//		return authorityRoleDao.getEntity("security.getSysAuthorityRoleByRoleId", authorityRolesId);
//	}
	@Override
	public List<SysAuthoritiesResources> getResourcesAuthorityByRoleId(
			String roleId) throws Exception {
		return authoritiesResourcesDao.getEntityList("security.getResourcesAuthorityByRoleId", roleId) ;
		 
	}

}
