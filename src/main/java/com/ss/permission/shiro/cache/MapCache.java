/**  <p>.</p> */
package com.ss.permission.shiro.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.util.Assert;

/**
 * <p> SimpleMapCache.java.</p>
 * <p>Description: 缓存实现类第三方存储(Map存放键值对)  <p>把资源放到map里 <p> 然后newMapCache(Map)就生成一个缓存堆,最后添加到缓存管理器里面即可 .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年3月16日: 下午1:57:24
 * @param <V>
 */
public class MapCache implements Cache<Object, Object>,Serializable {
	
	/**  <p>.</p> */
	private static final long serialVersionUID = -4361286006679866207L;
	private final Map<Object,Object> attributes;
	private final String name;
	
	public MapCache(String name,Map<Object,Object> map) {
		Assert.hasText(name,"parameter name is null !") ;
		Assert.isNull(map);
		this.name=name;
		this.attributes=map;
	}

	@Override
	public void clear() throws CacheException {
		attributes.clear();
	}

	/**
	 * @see org.apache.shiro.cache.Cache#get(java.lang.Object)
	 */
	@Override
	public Object get(Object key) throws CacheException {
		return attributes.get(key);
	}
	
	/**
	 * @see org.apache.shiro.cache.Cache#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Object put(Object key, Object value) throws CacheException {
		return attributes.put(key, value);
	}
	
	@Override
	public Object remove(Object key) throws CacheException {
		return attributes.remove(key);
	}

	@Override
	public Set<Object> keys() {
		Set<Object> keys = attributes.keySet();
		if(!keys.isEmpty()){
			return Collections.unmodifiableSet(keys);
			
		}else{
			return Collections.emptySet();
		}
	}
	

	@Override
	public int size() {
		return  attributes.size()	;
	}

	@Override
	public Collection<Object> values() {
		Set<Object> values = attributes.keySet();
		if(values.isEmpty())
			return Collections.unmodifiableCollection(values);
		else
			return Collections.emptySet();
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return (new StringBuilder("MapCache '")).append(name).append("' (").append(attributes.size()).append(  
                " entries)").toString();
	}
	

}
