/**  <p>.</p> */
package com.framework.orm.page;

import java.util.List;
import java.util.Map;

/**
 * <p> DataSourceResult.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年1月30日: 上午11:18:50
 */
public class DataSourceResult {
	
	private long total;
	private List<?> data;
	private Map<String, Object> aggregates;
	
	public Map<String, Object> getAggregates() {
		return aggregates;
	}
	public void setAggregates(Map<String, Object> aggregates) {
		this.aggregates = aggregates;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	

}
