/**  <p>.</p> */
package com.framework.orm.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> Page.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年3月30日: 上午8:49:56
 * @param <T>
 */

public class Page<T> {
	
	private static int defaultPageSize=10;
	/**  <p>默认的当前页数.</p> */
	private static long defaultCurrent=1;
	
	/**  <p>当前页数.</p> */
	private long current=defaultPageSize;
	
	
	
	/**  <p>每页条数.</p> */
	private int pageSize ;
	
	/**  <p> 数据总数.</p> */
	private long total;
	
	/**  <p>数据集合.</p> */
	private Collection<?> data = new ArrayList<T>();
	
	/**
	 * 查询条件 需要自定义设置  map.put(key,value);
	 */
	private  Map<String,Object> searchMap = new  HashMap<String,Object>();
	
	public Map<String, Object> getSearchMap() {
		return searchMap;
	}
	public void setSearchMap(Map<String, Object> searchMap) {
		this.searchMap = searchMap;
	}
	
	public Page(long current,int pageSize){
		this.current=current;
		this.pageSize=pageSize;
	}
	
	public Page(){
		this.current=defaultCurrent;
		this.pageSize=defaultPageSize;
	}

	public long getTotalPage() {
		return (total%pageSize ==0?total/pageSize:total/pageSize+1);
	}
	
	public long getCurrent() {
		return current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Collection<?> getData() {
		return data;
	}

	public void setData(Collection<?> data) {
		this.data = data;
	}
	public void setTotalPage(long totalPage) {
	}


	
	
	
	

}
