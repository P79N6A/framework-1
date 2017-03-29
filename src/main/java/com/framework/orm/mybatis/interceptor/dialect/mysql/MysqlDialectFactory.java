/**  <p>.</p> */
package com.framework.orm.mybatis.interceptor.dialect.mysql;

import com.framework.orm.mybatis.interceptor.dialect.BaseDialectFactory;
import com.framework.orm.mybatis.interceptor.dialect.BaseLimitPageDialect;

/**
 * <p> MysqlDialect.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Nov 24, 2014: 10:24:23 AM
 */
public class MysqlDialectFactory implements BaseDialectFactory {
	private  final static String MYSQL="mysql" ;
	
	/**
	 *(non-Javadoc)
	 * @see com.framework.orm.mybatis.interceptor.dialect.BaseDialectFactory#factoryDialect(java.lang.String)
	 */
	@Override
	public BaseLimitPageDialect factoryDialect(String dataBaseType) {
		if (dataBaseType.equals(MYSQL)) {
			return new MySqlLimitPageDialect();
		}
		return null;
	}

}
