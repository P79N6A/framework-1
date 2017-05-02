package com.ss.permission.security.service.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.ss.permission.security.entity.SysAuthoritiesResources;
import com.ss.permission.security.entity.SysAuthorityRole;
import com.ss.permission.security.entity.SysAuthorityUser;
import com.ss.permission.security.entity.SysAuthorityUserRole;
import com.ss.permission.security.service.ISecurityService;
import com.ss.permission.security.service.IUserDetailsService;
@Service("userDetailsService")
public class UserDetailsService implements IUserDetailsService {
	@Autowired
	private ISecurityService securityService ;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Assert.hasText(userName, "userName不能为空");
		try {
			  SysAuthorityUser authorityUser= securityService.getSysAuthorityUserByUserName(userName);
			 
			  if(null==authorityUser){
				  throw new UsernameNotFoundException("用户/密码错误,请重新输入!");
			  }
			  
			  Set<SysAuthorityRole> roles = new HashSet<SysAuthorityRole>();
			  for(SysAuthorityUserRole authorityUserRole :authorityUser.getSysAuthorityUserRoles()){
				  roles.add(authorityUserRole.getSysAuthorityRoles());
			  }
			  
			  Collection<GrantedAuthority> gaRoles = new HashSet<GrantedAuthority>();
			
			  for(SysAuthorityRole authorityRole:roles){
				  List<SysAuthoritiesResources> list =securityService.getResourcesAuthorityByRoleId(authorityRole.getAuthorityRolesId()) ;
				  for(SysAuthoritiesResources sysAuthoritiesResources:list){
					  //ROLE_
					  gaRoles.add(new SimpleGrantedAuthority(""+sysAuthoritiesResources.getSysAuthorities().getAuthoritiesName()));
				  }
			  }
			  authorityUser.setAuthorities(gaRoles);
			
			  return authorityUser;
			//SysAuthorityUser authorityUser = (SysAuthorityUser) baseDAO.getEntity("security.loadUserAndRolesByUsername", userName);
			//List<GrantedAuthority> grantedAuths = obtainGrantedAuthorities(authorityUser);
		} catch (Exception e) {
			
		}
		return null;
	}

}
