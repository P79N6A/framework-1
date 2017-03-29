/**  <p>.</p> */
package com.framework.orm.mybatis.interceptor.dialect.mysql;


import com.framework.orm.mybatis.interceptor.dialect.BaseLimitPageDialect;
import com.framework.orm.page.DataSourceRequest;

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
	 *(non-Javadoc)
	 * @see com.framework.orm.mybatis.interceptor.dialect.BaseLimitPageDialect#getLimitSqlString(com.framework.orm.page.DataSourceRequest, java.lang.String)
	 */
	public String getLimitSqlString(DataSourceRequest dataSourceRequest ,
			String sql) {
		int offset = (dataSourceRequest.getPage() - 1) * dataSourceRequest.getPageSize();
		String sqlString = sql +" limit "+ offset +" ,"+ dataSourceRequest.getPageSize();
		//String sqlString =  sql.replaceAll("[^\\s,]+\\.", "") +" limit "+ offset +" ,"+ page.getPageSize();
		return sqlString;
		//StringBuffer sqlBuffer = new StringBuffer(sql);
		//sqlBuffer.append(" limit ").append(offset).append(",").append(page.getPageSize());
		//return sqlBuffer.toString(); 
	}
	

	
	
	
		
		
		
	

}
