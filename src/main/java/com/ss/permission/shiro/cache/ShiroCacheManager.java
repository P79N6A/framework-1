package com.ss.permission.shiro.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;

import com.framework.cache.ICacheManager;

/**
 * <p> ShiroCacheManager.java.</p>
 * <p>Description: 安全框架缓存管理器 .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年3月17日: 下午2:24:43
 */
public class ShiroCacheManager implements CacheManager,Destroyable {
	
	private ICacheManager cacheManager;

	@Override
	public void destroy() throws Exception {
		cacheManager.destroy();
		
	}

	@Override
	public  Cache<Object, Object> getCache(String name) throws CacheException {
		// TODO Auto-generated method stub
		return cacheManager.getCache(name);
	}

	public ICacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(ICacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	

}
