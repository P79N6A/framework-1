/**  <p>.</p> */
package com.framework.util;

/**
 * <p> Strings.java.</p>
 * <p>Description: 字符串工具类 .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2013-1-25: 下午04:10:14
 */
public class StringUtils {
	
	 /**
	 *<p>Description:判断是否为空串  .</p> 
	 *<p>@param cs
	 *<p>@return boolean
	 *@since 2017年5月3日: 上午10:39:23
	 *@author xubin
	 *@version 1.0
	 */
	public static boolean isBlank(CharSequence cs)
	   {
	     if (null == cs)
	       return true;
	     int length = cs.length();
	     for (int i = 0; i < length; i++) {
	       if (!Character.isWhitespace(cs.charAt(i)))
	         return false;
	     }
	     return true;
	   }
    /**
     * 
     *<p>Description:将字符串首字母大写  .</p> 
     *<p>@param s
     *<p>@return String
     *@since 2014 10:13:02 AM
     *@author xubin
     *@version 1.0
     */
	public static String capitalize(CharSequence s) {
		if (null == s)
			return null;
		int len = s.length();
		if (len == 0)
			return "";
		char char0 = s.charAt(0);
		if (Character.isUpperCase(char0))
			return s.toString();
		return new StringBuilder(len).append(Character.toUpperCase(char0))
				.append(s.subSequence(1, len)).toString();
	}
	
	public static void main(String args[]) {
		System.out.println(isBlank(null));
	}

}
