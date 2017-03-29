/**  <p>.</p> */
package com.framework.orm.mybatis.interceptor.dialect;



/**
 * <p> DialectFactory.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Nov 24, 2014: 10:21:51 AM
 */
public interface BaseDialectFactory {

	public BaseLimitPageDialect factoryDialect(String dataBaseType);

}
