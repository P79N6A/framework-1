package com.ss.permission.shiro.service;


import com.ss.permission.shiro.entity.SysSession;


public interface ISysSessionService {
	
	void insertSysSession(SysSession sysSession) throws Exception;
	
	int updateSysSession(SysSession sysSession) throws Exception;
	
	int deleteSysSessionById(SysSession sysSession) throws Exception;
	
	SysSession selectSysSessionById(String sysSessionId) throws Exception;
	
    //Page getSysSessionPage (SysSession searchCondition) throws Exception;

}