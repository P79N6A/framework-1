/**  <p>.</p> */
package com.framework.orm.mybatis.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.util.Assert;

import com.framework.orm.mybatis.dao.IBaseDao;
import com.framework.orm.mybatis.entity.TableColumnEntity;

/**
 * <p> BaseDao.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2015年2月9日: 下午1:55:02
 */
public class BaseDao<E extends Serializable> extends SqlSessionDaoSupport implements IBaseDao<E> {
	public final static String TABLE_NAME = "TABLE_NAME";

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
	
	@Override
	public void deleteEntityById(String table_name, Map<String, Object> map)
			throws Exception {
		Assert.notNull(table_name,"parameter table_name is null !") ;
		Map<String, Object> parMap = new HashMap<String, Object>();
		parMap.put(TABLE_NAME, table_name);
		if (null != map && !map.isEmpty()) {
			List<TableColumnEntity> list = new ArrayList<TableColumnEntity>();
			TableColumnEntity deleteTableEntity = null;
			for (String key : map.keySet()) {
				deleteTableEntity = new TableColumnEntity(key,
						(String) map.get(key));
				list.add(deleteTableEntity);
			}
			parMap.put("list", list);
		}
		getSqlSession().delete("base.deleteByTableName", parMap);

	}


	

}
