/**  <p>.</p> */
package com.ss.permission.shiro;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
/**
 * <p> SerializableUtil.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年5月4日: 下午5:25:39
 */
public class SerializableUtil {
	/**
	 *<p>Description:  .</p> 
	 *<p>@param session
	 *<p>@return String
	 *@since 2015年5月4日: 下午5:26:07
	 *@author xubin
	 *@version 1.0
	 */
	public static String serialize(Session session) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(session);
			return Base64.encodeToString(bos.toByteArray());
		} catch (Exception e) {
			throw new RuntimeException("serialize session error", e);
		}
	}

	/**
	 *<p>Description:  .</p> 
	 *<p>@param sessionStr
	 *<p>@return Session
	 *@since 2015年5月4日: 下午5:26:09
	 *@author xubin
	 *@version 1.0
	 */
	public static Session deserialize(String sessionStr) {
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(
					Base64.decode(sessionStr));
			ObjectInputStream ois = new ObjectInputStream(bis);
			return (Session) ois.readObject();
		} catch (Exception e) {
			throw new RuntimeException("deserialize session error", e);
		}
	}

}
