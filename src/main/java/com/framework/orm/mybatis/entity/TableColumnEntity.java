/**  <p>.</p> */
package com.framework.orm.mybatis.entity;

/**
 * <p> DeleteTableEntity.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Sep 19, 2014: 3:26:36 PM
 */
public class TableColumnEntity {
	private String tableColumn;
	private String tableColumnValue;
	
	public TableColumnEntity(String tableColumn ,String tableColumnValue){
		this.tableColumn =tableColumn;
		this.tableColumnValue =tableColumnValue;
	}
	
	public String getTableColumn() {
		return tableColumn;
	}
	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}
	public String getTableColumnValue() {
		return tableColumnValue;
	}
	public void setTableColumnValue(String tableColumnValue) {
		this.tableColumnValue = tableColumnValue;
	}
	

}
