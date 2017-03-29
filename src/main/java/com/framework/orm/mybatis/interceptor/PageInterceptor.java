package com.framework.orm.mybatis.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import com.framework.orm.mybatis.interceptor.dialect.BaseLimitPageDialect;
import com.framework.orm.mybatis.interceptor.dialect.util.PageLimitUtil;
import com.framework.orm.page.DataSourceRequest;


/**
 * 
 * <p> PageInterceptor.java.</p>
 * <p>Description: 分页拦截器 <br>
 * 需要在mybatis-config.xml增加如下配置:<br>
 *      &ltplugins&gt<br>
 *		&ltplugin  interceptor="com.framework.orm.mybatis.interceptor.PageInterceptor" &gt<br>
 *      &lt!-- value要根据数据库类型设置如：oracle，mysql 目前只支持这俩种类型  --&gt<br>
 *      &ltproperty name="dataBaseType" value="mysql" /&gt<br>
 *		&lt/plugin &gt<br>
 *	    &lt/plugins&gt<br></p>
 * <p>Company: </p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * <p>@since Jan 24, 2014: 1:56:58 PM</p>
 */
@Intercepts({@Signature(args = {Connection.class}, method = "prepare", type =StatementHandler.class )})
public class PageInterceptor implements  Interceptor {
	private static Log log = LogFactory.getLog(PageInterceptor.class);
	
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static final ReflectorFactory DEFAULT_REFLECTORFACTORY = new DefaultReflectorFactory();
	

	
	/** 数据库类型  需要在mybatis-config.xml配置   */
	private  String dataBaseType;
	public String getDataBaseType() {
		return dataBaseType;
	}
	public void setDataBaseType(String dataBaseType) {
		this.dataBaseType = dataBaseType;
	}
	/**
	 *(non-Javadoc)
	 *<b>拦截时候要执行的方法
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		Object obj = boundSql.getParameterObject();
		String sql = boundSql.getSql();
		//TODO mybatis3.1.1 
		//MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);
		//TODO mybatis3.2.5
		//MetaObject metaStatementHandler =MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		//TODO mybatis 3.3
		MetaObject metaStatementHandler =MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,DEFAULT_REFLECTORFACTORY);
		
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		Connection connection = (Connection)invocation.getArgs()[0]; 
		if(obj instanceof DataSourceRequest){
			DataSourceRequest page = (DataSourceRequest)obj;
			//拦截到的prepare方法参数是一个Connection对象  
		    String pageSql =  (PageLimitUtil.get(dataBaseType).factoryDialect(dataBaseType)).getLimitSqlString(page, sql);
		    //给当前的page参数对象设置总记录数  
		    this.setTotalRecord(page,mappedStatement, connection); 
		    metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
		    log.debug("=================>PageInterceptor intercept start分页拦截Page开始sql<======================="
		    		  +"\n==>dataBaseType:["+this.dataBaseType+"]"
		    		  +"\n==>sql:["+sql+"]"
		    		  +"\n==>pageSql:["+pageSql+"]"
		    		 // +"\n==>第【"+page.getCurrentPageNo()+"】页|"
		    		  //+"共【"+page.getTotalPages()+"】页|"
		    		  +"每页显示【"+page.getPageSize()+"】条|"
		    		 // +"总记录数:【"+page.getTotalRecords()+"】"
		    		 );
		
		}else{
			log.debug("=================> intercept sql <======================="
					+ "\n==>sql:[" + sql + "]");

		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		 return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		String type = properties.getProperty("dataBaseType");
		if(null!=type && !"".equals(type)){
			this.dataBaseType = properties.getProperty("dataBaseType");
		}else{
			log.error("============> mybatis-config.xml not fount  property name 'dataBaseType'<===========");
			throw new  NullPointerException();
		}
		 
	}
	
   private void setTotalRecord(DataSourceRequest page,  MappedStatement mappedStatement, Connection connection) {  
		
		BoundSql boundSql = mappedStatement.getBoundSql(page);
		String sql = boundSql.getSql();
		String countSql =BaseLimitPageDialect.getCountLimitSql(sql);
		log.debug("=================>PageInterceptor setTotalRecord start<======================="
				  +"\n==>sql:["+sql+"]"+"\n==>countSql:["+countSql+"]");
		// 通过BoundSql获取对应的参数映射
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		// 利用Configuration、查询记录数的Sql语句countSql、参数映射关系parameterMappings和参数对象page建立查询记录数对应的BoundSql对象。
		BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql,parameterMappings, page);
		// 通过mappedStatement、参数对象page和BoundSql对象countBoundSql建立一个用于设定参数的ParameterHandler对象
		ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, page, countBoundSql);
		// 通过connection建立一个countSql对应的PreparedStatement对象。
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(countSql);
			parameterHandler.setParameters(pstmt);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Long totalRecord = rs.getLong(1);
				//TODO 需要修改page里面的中记录数是long  给当前的参数page对象设置总记录数  
				page.setTotal(totalRecord.intValue());
				
			}
		} catch (SQLException e) {
			log.error(e,e.getCause());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				log.error(e,e.getCause());
			}
		}
	}


}
