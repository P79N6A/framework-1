/**  <p>.</p> */
package com.framework.orm.mybatis.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.util.Assert;

import com.framework.orm.mybatis.dao.IBaseDao;

/**
 * <p> BaseDao.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年2月9日: 下午1:55:02
 */
public class BaseDao<E extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<E> {

	@Override
	public void insert(String paramString, Object entity) throws Exception {
		Assert.hasText(paramString,"entity paramString is null !") ;
		getSqlSession().insert(paramString, entity);
		
	}

	@Override
	public int delete(String paramString, Object entity) throws Exception {
		Assert.hasText(paramString,"entity paramString is null !") ;
		return getSqlSession().delete(paramString, entity) ;
		
	}

	@Override
	public E getEntity(String paramString, Object entity) throws Exception {
		Assert.hasText(paramString,"entity paramString is null !") ;
		return getSqlSession().selectOne(paramString, entity);
	}

	@Override
	public List<E> getEntityList(String paramString, Object entity)
			throws Exception {
		Assert.hasText(paramString,"entity paramString is null !") ;
		return getSqlSession().selectList(paramString, entity);
	}

	@Override
	public long getResultTypeCount(String paramString, Object entity)
			throws Exception {
		Assert.hasText(paramString,"entity paramString is null !") ;
		return getSqlSession().selectOne(paramString,entity) ;
	}

	@Override
	public int updateStatement(String paramString, Object entity)
			throws Exception {
		Assert.hasText(paramString,"entity paramString is null !") ;
		return  getSqlSession().update(paramString, entity);	
	}

	@Override
	public int insertIsSuccess(String paramString, Object entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	

}
