package com.ss.permission.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.permission.shiro.dao.SysSessionDao;
import com.ss.permission.shiro.entity.SysSession;
import com.ss.permission.shiro.service.ISysSessionService;

@Service("sysSessionService")
public class SysSessionService implements ISysSessionService{
	@Autowired
	private SysSessionDao sysSessionDao;
	
	@Override
	public void insertSysSession(SysSession sysSession) throws Exception{
		
		 sysSessionDao.insert("sysSession.insertSysSession",  sysSession);
	}
	
	@Override
	public int updateSysSession(SysSession sysSession) throws Exception{
		 SysSession selectsysSession =selectSysSessionById( sysSession.getSessionId()) ;
		 if( null !=selectsysSession){
			 return   sysSessionDao.updateStatement("sysSession.updateSysSession",  sysSession);
		 
		 }
		 return 0;
		
	}
	
	@Override
	public int deleteSysSessionById(SysSession sysSession) throws Exception{
		 SysSession selectsysSession =selectSysSessionById( sysSession.getSessionId()) ;
		 if( null !=selectsysSession){
			 return sysSessionDao.delete("sysSession.deleteSysSessionById", selectsysSession.getSessionId());
		 }
		 return 0;
	}
	
	@Override
	public SysSession selectSysSessionById(String sysSessionId) throws Exception{
		
		return sysSessionDao.getEntity("sysSession.selectSysSessionById",sysSessionId) ;
		
	}
	
//	@Override
//	public Page getIncidentList(SysSessionEntity searchCondition) throws Exception{
//		
//	}
	
}