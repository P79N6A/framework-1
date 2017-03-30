/**  <p>.</p> */
package com.framework.orm.mybatis.interceptor.dialect.mysql;


import com.framework.orm.mybatis.interceptor.dialect.BaseLimitPageDialect;
import com.framework.orm.page.Page;

/**
 * <p> MySqlDialect.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * <p>@since Feb 10, 2014: 10:21:13 AM</p>
 */
public class MySqlLimitPageDialect extends BaseLimitPageDialect {

	/**
	 * 
	 * (non-Javadoc)
	 * 
	 * @see com.framework.orm.mybatis.interceptor.dialect.BaseLimitPageDialect#getLimitSqlString(com.framework.orm.page.Page,
	 *      java.lang.String)
	 */
	@Override
	public String getLimitSqlString(Page page, String sql) {
		long offset = (page.getCurrent() - 1) * page.getPageSize();
		//String sqlString = sql + " limit " + offset + " ," + page.getPageSize();
		// String sqlString = sql.replaceAll("[^\\s,]+\\.", "") +" limit "+
		// offset +" ,"+ page.getPageSize();
		//return sqlString;
		 StringBuffer sqlBuffer = new StringBuffer(sql);
		 sqlBuffer.append(" limit ").append(offset).append(",").append(page.getPageSize());
		 return sqlBuffer.toString();
	}
	

	
	
	
		
		
		
	

}
