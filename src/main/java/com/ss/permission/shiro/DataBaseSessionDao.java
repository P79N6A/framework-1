/**  <p>.</p> */
package com.ss.permission.shiro;

import java.io.Serializable;
import java.util.Collection;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import com.ss.permission.shiro.entity.SysSession;
import com.ss.permission.shiro.service.ISysSessionService;

/**
 * <p> DataBaseSessionDao.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年5月4日: 下午4:55:48
 */
public class DataBaseSessionDao extends AbstractSessionDAO {
	@Autowired
	private ISysSessionService sessionService;

	/**
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#update(org.apache.shiro.session.Session)
	 */
	@Override
	public void update(Session session) throws UnknownSessionException {
		if (session instanceof ValidatingSession
				&& !((ValidatingSession) session).isValid()) {
			return;
		}
		SysSession sysSession = new SysSession();
		sysSession.setSessionId((String) session.getId());
		sysSession.setSession(SerializableUtil.serialize(session));
		try {
			sessionService.updateSysSession(sysSession);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#delete(org.apache.shiro.session.Session)
	 */
	@Override
	public void delete(Session session) {
		SysSession sysSession = new SysSession();
		sysSession.setSessionId((String) session.getId());
		sysSession.setSession(SerializableUtil.serialize(session));
		try {
			sessionService.deleteSysSessionById(sysSession);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see org.apache.shiro.session.mgt.eis.SessionDAO#getActiveSessions()
	 */
	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see org.apache.shiro.session.mgt.eis.AbstractSessionDAO#doCreate(org.apache.shiro.session.Session)
	 */
	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		SysSession sysSession = new SysSession();
		sysSession.setSessionId((String) sessionId);
		sysSession.setSession(SerializableUtil.serialize(session));
		try {
			sessionService.insertSysSession(sysSession);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
		return sysSession.getSessionId();
	}

	/**
	 * @see org.apache.shiro.session.mgt.eis.AbstractSessionDAO#doReadSession(java.io.Serializable)
	 */
	@Override
	protected Session doReadSession(Serializable sessionId) {
		try {
			SysSession session = sessionService.selectSysSessionById((String) sessionId);
			if(null ==session){
				return null;
			}
			String s = session.getSessionId()+""+session.getSession();
			return SerializableUtil.deserialize(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
