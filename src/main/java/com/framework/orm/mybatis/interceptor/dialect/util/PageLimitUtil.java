/**  <p>.</p> */
package com.framework.orm.mybatis.interceptor.dialect.util;

import com.framework.orm.mybatis.interceptor.dialect.BaseDialectFactory;
import com.framework.orm.mybatis.interceptor.dialect.mysql.MysqlDialectFactory;

/**
 * <p> PageLimitUtil.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Nov 24, 2014: 10:59:18 AM
 */
public class PageLimitUtil {
	
	public static BaseDialectFactory get(String dataBaseType ){
		BaseDialectFactory baseDialectFactory=null;
		if ("mysql".equalsIgnoreCase(dataBaseType)) {
			return  new MysqlDialectFactory();
		} 
		/**else if ("oracle".equalsIgnoreCase(dataBaseType)) {
			return  new OracleDialectFactory();
		}*/
		return baseDialectFactory;
		
	}

}
