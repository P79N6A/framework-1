/**  <p>.</p> */
package com.framework.orm.page;

/**
 * <p> DateSourceRequest.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年2月16日: 下午4:34:02
 */
public class DataSourceRequest {
	
	/**  <p>每页默认记录数.</p> */
	private static int DEFAULT_PAGE_SIZE=10;
	
	/**  <p>分页.</p> */
	private int page;
	/**  <p>总页数.</p> */
	private int pageSize;
	/**  <p>每页取多少条记录 默认是15条.</p> */
	private int take;
	/**  <p>查询的第一条记录.</p> */
	private int skip;
	/**  <p>总记录数.</p> */
	private long total;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTake() {
		return take;
	}
	public void setTake(int take) {
		this.take = take;
	}
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

}
