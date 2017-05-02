/**  <p>.</p> */
package com.ss.permission.security.entity;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

/**
 * <p> BaseUserDetailsEntity.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2014-8-18: 下午5:22:06
 */
public  abstract class  BaseUserDetailsEntity implements IBaseUserDetailsEntity {
	private  Set<GrantedAuthority> authorities;
	private  String password;
	private  String username;
	private  boolean accountNonExpired =true;
	private  boolean accountNonLocked =true;
	private  boolean credentialsNonExpired =true;
	private  boolean  enabled=true;
	
	public void setAuthorities( Collection<GrantedAuthority> authorities ){
    	this.authorities = (Set<GrantedAuthority>) authorities;
    }

	/**  <p>.</p> */
	private static final long serialVersionUID = -8704196263713000349L;

	/**
	 *(non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	/**
	 *(non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}

	/**
	 *(non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return username;
	}

	/**
	 *(non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	/**
	 *(non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	/**
	 *(non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	/**
	 *(non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
