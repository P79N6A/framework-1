package com.framework.orm.mybatis.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p> IBaseDao.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年1月29日: 下午4:59:39
 */

public interface IBaseDao <E extends Serializable> {
	
	/**
	 *<p>Description:保存实体  .</p> 
	 *<p>@param statement
	 *<p>@param entity
	 *<p>@throws Exception void
	 *@since 2017年1月29日: 下午5:14:26
	 *@author xubin
	 *@version 1.0
	 */
	public void insert(String paramString,Object entity) throws Exception;
	/**
	 * 
	 *<p>Description:保存实体  .</p> 
	 *<p>@param paramString
	 *<p>@param entity
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2017年1月29日: 下午5:15:36
	 *@author xubin
	 *@version 1.0
	 */
	public int insertIsSuccess(String paramString,Object entity) throws Exception;
	/**
	 * 
	 *<p>Description:  .</p> 
	 *<p>@param paramString
	 *<p>@param entity
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2017年1月29日: 下午5:16:22
	 *@author xubin
	 *@version 1.0
	 */
	public int delete(String paramString,Object parameter) throws Exception;
	
	/**
	 * 
	 *<p>Description: 返回实体对象 .</p> 
	 *<p>@param paramString
	 *<p>@param entity
	 *<p>@return
	 *<p>@throws Exception E
	 *@since 2017年1月29日: 下午5:16:30
	 *@author xubin
	 *@version 1.0
	 */
	public E getEntity(String paramString,Object entity) throws Exception;

	/**
	 *<p>Description: 返回实体集合 .</p> 
	 *<p>@param paramString
	 *<p>@param prameter
	 *<p>@return
	 *<p>@throws Exception List<E>
	 *@since 2017年1月29日: 下午5:18:17
	 *@author xubin
	 *@version 1.0
	 */
	public List<E> getEntityList(String paramString,Object entity) throws Exception;
	
	/**
	 *<p>Description:返回结果集个数  .</p> 
	 *<p>@param statment
	 *<p>@param entity
	 *<p>@return
	 *<p>@throws Exception long
	 *@since 2017年1月29日: 下午5:20:11
	 *@author xubin
	 *@version 1.0
	 */
	public long getResultTypeCount(String statment,Object entity) throws Exception;
	
	/**
	 *<p>Description: 更新记录并返回影响条数 .</p> 
	 *<p>@param paramString
	 *<p>@param prameter
	 *<p>@return
	 *<p>@throws Exception int
	 *@since 2017年1月29日: 下午5:21:17
	 *@author xubin
	 *@version 1.0
	 */
	public int updateStatement(String paramString,Object prameter) throws Exception;
	
	/**
	 *<p>Description:单表删除  .</p> 
	 *<p>@param table_name 
	 *<p>@param map
	 *<p>@throws Exception void
	 *@since Oct 13, 2014: 1:58:21 PM
	 *@author xubin
	 *@version 1.0
	 */
	public void deleteEntityById(String table_name,Map<String, Object> map)throws Exception;
	
	

}
