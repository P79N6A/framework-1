package com.ss.permission.security.service.impl;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

/**
 * <p> SecurityAccessDecisionManager.java.</p>
 * <p>Description:  自定义资源权限关系认证 访问决策器，决定某个用户具有的角色，是否有足够的权限去访问某个资源。 .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Sep 16, 2014: 9:35:05 AM
 */
@Service("accessDecisionManager")
public class SecurityAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object arg1,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			return;
		}
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
		while (ite.hasNext()) {
			ConfigAttribute ca = ite.next();
			String needRole = ca.getAttribute();
			// ga 为用户所被赋予的权限。 needRole 为访问相应的资源应该具有的权限。
			// 用户所拥有的权限authentication
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needRole.trim().equals(ga.getAuthority().trim())) {
					return;
				}
			}
		}

		throw new AccessDeniedException("没有权限访问!");

	}

	@Override
	public boolean supports(ConfigAttribute arg0) {
		return true;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
