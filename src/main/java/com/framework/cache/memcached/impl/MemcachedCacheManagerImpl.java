/**  <p>.</p> */
package com.framework.cache.memcached.impl;

import net.rubyeye.xmemcached.MemcachedClient;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.util.Assert;

import com.framework.cache.ICacheManager;


/**
 * <p> SimpleCacheManagerImpl.java.</p>
 * <p>Description:缓存管理实现类  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年3月16日: 下午2:20:29
 */
public class MemcachedCacheManagerImpl implements ICacheManager {
	
	 private MemcachedClient memcachedClient;
	 
	 public MemcachedCacheManagerImpl(MemcachedClient memCachedClient) {
		 Assert.isNull(memCachedClient,"parameter memCachedClient is null !");
		 this.memcachedClient = memCachedClient;
	 }

	/**
	 * @see com.framework.cache.ICacheManager#createCache(java.lang.String, org.apache.shiro.cache.Cache)
	 */
	@Override
	public void createCache(String key, Cache<Object, Object> cache)
			throws CacheException {
		//
		try{
			memcachedClient.set(key, 0, cache);
		}catch(Exception exception) {
			throw new CacheException(exception);
		}
	}

	/**
	 * @see com.framework.cache.ICacheManager#getCache(java.lang.String)
	 */
	@Override
	public Cache<Object, Object> getCache(String name) throws CacheException {
		try{
			return  memcachedClient.get(name);
		}catch(Exception exception) {
			throw new CacheException(exception);
		}
		
	}

	/**
	 * @see com.framework.cache.ICacheManager#removeCache(java.lang.String)
	 */
	@Override
	public void removeCache(String name) throws CacheException {
	
		try{
			memcachedClient.delete(name);
		}catch(Exception exception) {
			throw new CacheException(exception);
		}
	}

	/**
	 * @see com.framework.cache.ICacheManager#updateCache(java.lang.String, org.apache.shiro.cache.Cache)
	 */
	@Override
	public void updateCache(String name, Cache<Object, Object> cache)
			throws CacheException {
		try{
			memcachedClient.replace(name,0, cache);
		}catch(Exception exception) {
			throw new CacheException(exception);
		}
		
	}

	/**
	 * @see com.framework.cache.ICacheManager#destroy()
	 */
	@Override
	public void destroy() throws CacheException {

		try {
			memcachedClient.shutdown();
		} catch (Exception e) {
			throw new CacheException(e);
		}
	}

}
