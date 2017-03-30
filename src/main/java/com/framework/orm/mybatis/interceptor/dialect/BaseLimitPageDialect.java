package com.framework.orm.mybatis.interceptor.dialect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.framework.orm.page.Page;
public abstract class BaseLimitPageDialect {

	
	public abstract String getLimitSqlString(Page dataSourceRequest,String sql);
	
	/**
	 * 
	 *<p>Description:<P> 据原Sql语句获取对应的查询总记录数的Sql语句 去除sql的select 子句，未考虑union的情况.<br></p> 
	 *<p>@param sql
	 *<p>@return String
	 *<p>@author xubin</p>
	 *<p>@since Jan 24, 2014: 3:33:23 PM
	 */
	public static String getCountLimitSql(String sql) {
		String notOrderby = removeOrders(sql);
		int index = notOrderby.toLowerCase().indexOf("from");
		return "select count(1) " + notOrderby.substring(index);
	}
	/**
	 * 
	 *<p>Description:去除 order by.</p> 
	 *<p>@param hql
	 *<p>@return String
	 *<p>@author xubin</p>
	 *<p>@since Feb 11, 2014: 9:23:04 AM
	 */
	private static  String removeOrders(String sql) {
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*",
				Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(sql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
}
