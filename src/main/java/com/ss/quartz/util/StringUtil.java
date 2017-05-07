/**  <p>.</p> */
package com.ss.quartz.util;

/**
 * <p> StringUtil.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年7月16日: 上午10:48:08
 */
public class StringUtil {
	
	StringUtil(){
		
	}
	
	/**
	 * 
	 *<p>Description:判断是否为空   .</p> 
	 *<p>@param string
	 *<p>@return boolean 如果null 或者"" 返回true 
	 *@since 2014-4-18: 下午4:31:07
	 *@author xubin
	 *@version 1.0
	 */
	 public  boolean isNull(CharSequence string)
	   {
	     if (null == string)
	       return true;
	     int length = string.length();
	     for (int i = 0; i < length; i++) {
	       if (!Character.isWhitespace(string.charAt(i)))
	         return false;
	     }
	     return true;
	   }
	
	 /**
	  * 
	  *<p>Description:判断字符串不为null   .</p> 
	  *<p>@param string
	  *<p>@return boolean 如果null 或者"" 返回false 不为null ""返回true 
	  *@since 2014-5-28: 下午5:05:28
	  *@author xubin
	  *@version 1.0
	  */
	 public  boolean isNotBlank(CharSequence string){
		 return  !isNull(string);
	 }
	 
	 /**
	 *<p>Description:  .</p> 
	 *<p>@param string
	 *<p>@return boolean
	 *@since 2015年6月24日: 下午2:42:35
	 *@author xubin
	 *@version 1.0
	 */
	public  boolean isEmpty(CharSequence string) {
		 return isNull(string) ;
	 }


}
