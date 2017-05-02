/**  <p>.</p> */
package com.framework.cache.ehcache.impl;

import net.sf.ehcache.CacheManager;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.framework.cache.ICacheManager;

/**
 * <p> EhcacheCacheManagerImpl.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年5月27日: 下午3:03:57
 */
public class EhcacheCacheManagerImpl implements ICacheManager {
	
	private CacheManager cacheManager;

	@Override
	public void createCache(String name, Cache<Object, Object> cache)
			throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cache<Object, Object> getCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCache(String name, Cache<Object, Object> cache)
			throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() throws CacheException {
		// TODO Auto-generated method stub
		
	}

}
