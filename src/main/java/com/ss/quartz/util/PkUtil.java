/**
 * 
 */
package com.ss.quartz.util;

import java.security.SecureRandom;


/**
 * <p> CodeUitl.java.</p>
 * <p>Description:code 工具类  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Nov 11, 2014: 5:24:05 PM
 */
public   class  PkUtil {
    PkUtil(){
    	
    }
	private static volatile SecureRandom sr = null;

	/**
	 *<p>Description: 生成32位的主键 .</p> 
	 *<p>@return String
	 *@since Nov 14, 2014: 1:41:28 PM
	 *@author xubin
	 *@version 1.0
	 */
	public  String getUuid() {
		byte[] b = new byte[32];
		sr = new SecureRandom();
		sr.nextBytes(b);
		return printable(b);
	}

	/**
	 *<p>Description:生成随机数字  .</p> 
	 *<p>@param length
	 *<p>@return String
	 *@since Nov 14, 2014: 1:41:51 PM
	 *@author xubin
	 *@version 1.0
	 */
	public  String getNumericRandomID(int length) {
		byte[] b = new byte[length];
		sr = new SecureRandom();
		sr.nextBytes(b);
		return printableNumber(b);
	}

	/**
	 *<p>Description:  .</p> 
	 *<p>@param b
	 *<p>@return String
	 *@since Nov 14, 2014: 1:40:03 PM
	 *@author xubin
	 *@version 1.0
	 */
	private  synchronized String printableNumber(byte[] b) {
		char[] alphabet = "1234567890".toCharArray();
		char[] out = new char[b.length];
		for (int i = 0; i < b.length; i++) {
			int index = b[i] % alphabet.length;
			if (index < 0) {
				index += alphabet.length;
			}
			out[i] = alphabet[index];
		}
		return new String(out);
	}
	
	/**
	 *<p>Description:生成编码(26个字母大小写10个数字)  .</p> 
	 *<p>@param b
	 *<p>@return String
	 *@since Nov 14, 2014: 1:39:39 PM
	 *@author xubin
	 *@version 1.0
	 */
	private static  synchronized String printable(byte[] b) {
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
				.toCharArray();

		char[] out = new char[b.length];
		for (int i = 0; i < b.length; i++) {
			int index = b[i] % alphabet.length;
			if (index < 0) {
				index += alphabet.length;
			}
			out[i] = alphabet[index];
		}
		return new String(out);
	}


}
