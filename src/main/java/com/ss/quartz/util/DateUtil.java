/**  <p>.</p> */
package com.ss.quartz.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.dao.DataAccessException;

/**
 * <p> DateUtil.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月15日: 下午3:41:24
 */
public class DateUtil {
	
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";

	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	DateUtil() {

	}
	/**
	 *<p>Description: 获得当前时间 .</p> 
	 *<p>@return
	 *<p>@throws DataAccessException Date
	 *@since 2015年7月15日: 下午3:57:09
	 *@author xubin
	 *@version 1.0
	 */
	public Date getCurrentDate() throws DataAccessException {
		return new Date();
	}
	/**
	 *<p>Description:  获得当前时间戳.</p> 
	 *<p>@return Timestamp
	 *@since 2015年7月15日: 下午3:57:05
	 *@author xubin
	 *@version 1.0
	 */
	public Timestamp getCurrentTimestamp() {
		Date time = getCurrentDate();
		return new Timestamp(time.getTime());
	}
	
	/**
	 *<p>Description:  .</p> 
	 *<p>@return
	 *<p>@throws DataAccessException String
	 *@since 2015年7月15日: 下午3:59:04
	 *@author xubin
	 *@version 1.0
	 */
	public String getDateString() throws DataAccessException {

		return getDateString(DEFAULT_DATE_FORMAT);
	}
	
	/**
	 *<p>Description:  .</p> 
	 *<p>@param formatter
	 *<p>@return String
	 *@since 2015年7月15日: 下午4:00:34
	 *@author xubin
	 *@version 1.0
	 */
	public String getDateString(String formatter) {
		SimpleDateFormat fmt = new SimpleDateFormat(
				formatter);
		return fmt.format(getCurrentDate());
	}

	

	

}
