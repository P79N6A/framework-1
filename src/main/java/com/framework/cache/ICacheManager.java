/**  <p>.</p> */
package com.framework.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

/**
 * <p> SimpleCacheManager.java.</p>
 * <p>Description: 缓存管理 .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年3月16日: 下午2:13:49
 */
public interface ICacheManager {
	
	/**
	 *<p>Description:  .</p> 
	 *<p>@param name
	 *<p>@param cache
	 *<p>@throws CacheException void
	 *@since 2015年3月16日: 下午2:19:19
	 *@author xubin
	 *@version 1.0
	 */
	public abstract void createCache(String name,Cache<Object, Object> cache) throws CacheException;
	/**
	 *<p>Description:  .</p> 
	 *<p>@param name
	 *<p>@return
	 *<p>@throws CacheException Cache<Object,Object>
	 *@since 2015年3月16日: 下午2:19:22
	 *@author xubin
	 *@version 1.0
	 */
	public abstract Cache<Object,Object> getCache(String name) throws CacheException;
	
	/**
	 *<p>Description:  .</p> 
	 *<p>@param name
	 *<p>@throws CacheException void
	 *@since 2015年3月16日: 下午2:19:25
	 *@author xubin
	 *@version 1.0
	 */
	public abstract void  removeCache(String name) throws CacheException;
	
	/**
	 *<p>Description:  .</p> 
	 *<p>@param name
	 *<p>@param cache
	 *<p>@throws CacheException void
	 *@since 2015年3月16日: 下午2:19:28
	 *@author xubin
	 *@version 1.0
	 */
	public abstract void updateCache(String name,Cache<Object,Object> cache) throws CacheException;
	
	/**
	 *<p>Description:  .</p> 
	 *<p>@throws CacheException void
	 *@since 2015年3月16日: 下午2:19:30
	 *@author xubin
	 *@version 1.0
	 */
	public abstract void destroy() throws CacheException;
	

}
