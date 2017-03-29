/**  <p>.</p> */
package com.ss.code.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.framework.orm.page.DataSourceResult;
import com.ss.code.bean.CodeBean;
import com.ss.code.dao.CodeDao;
import com.ss.code.service.ICodeService;
import com.ss.code.util.CodeUtils;

/**
 * <p> CodeService.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Nov 11, 2014: 5:40:14 PM
 */
@Service("codeService")
public class CodeService implements ICodeService {
	
	public final static String DELETE_STATUS="0";
	public final static String NORMAL_STATUS="1";
	
	@Autowired
	private CodeDao codeDao;
	
	private DataSourceResult toDataSourceReulst(
			DataSourceResult dataSourceRequest, List<?> data) throws Exception {
		DataSourceResult dataSourceReulst = new DataSourceResult();
		dataSourceReulst.setTotal(dataSourceRequest.getTotal());
		dataSourceReulst.setData(data);
		return dataSourceReulst;

	}
	
	public  DataSourceResult getList(DataSourceResult dataSourceRequest) throws Exception {
		
		return  toDataSourceReulst(dataSourceRequest ,codeDao.getEntityList("code.getList",dataSourceRequest));
	}
	/**
	 * 
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#getAllList(com.ss.code.bean.CodeBean)
	 */
	public  List<CodeBean> getAllList(CodeBean code) throws Exception{
		return  codeDao.getEntityList("code.getAllList", code);
	}
	
	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#getMaxNormalCodeNum(com.ss.code.bean.CodeBean)
	 */
	public CodeBean  getMaxNormalCodeNum(CodeBean codeBean) throws Exception {
		return  codeDao.getEntity("code.getMaxNormalCodeNum", codeBean);
	}
	
	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#saveCode(com.ss.code.bean.CodeBean)
	 */
	public void saveCode(CodeBean codeBean) throws Exception{
		codeDao.insert("code.saveCode", codeBean);
	}
	
	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#updateCodeStatus(com.ss.code.bean.CodeBean)
	 */
	public int updateCodeStatus(CodeBean codeBean) throws Exception{
		return  codeDao.getSqlSession().update("code.updateCodeStatus", codeBean);
	}
	
	
	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#getIsHaveDeleteCodeCount(com.ss.code.bean.CodeBean)
	 */
	public long  getIsHaveDeleteCodeCount(CodeBean codeBean) throws Exception{
		return  codeDao.getResultTypeCount("code.getIsHaveDeleteCodeCount",codeBean);
	}
	
	
	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#getMinDeleteCode(com.ss.code.bean.CodeBean)
	 */
	public CodeBean  getMinDeleteCode(CodeBean codeBean) throws Exception{
		return  codeDao.getSqlSession().selectOne("code.getMinDeleteCode",codeBean);
	}
	
	
	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#saveCodeAndReturnCode(com.ss.code.bean.CodeBean)
	 */
	public String  saveCodeAndReturnCode(CodeBean codeBean) throws Exception{
		CodeBean codeEntity = new CodeBean.Builder()
				.codeFirst(codeBean.getCodeFirst())
				.codeSecond(codeBean.getCodeSecond())
				.codeThree(codeBean.getCodeThree())
				.codeFour(codeBean.getCodeFour())
				.codeFive(codeBean.getCodeFive())
				.codeSix(codeBean.getCodeSix()).codeNum(codeBean.getCodeNum())
				.status(DELETE_STATUS).createDate(codeBean.getCreateDate()).createTime(codeBean.getCreateTime()).createTimestamp(codeBean.getCreateTimestamp()).build();
		long count = getIsHaveDeleteCodeCount(codeEntity);
		if (count == 0) {
			int max = (null != getMaxNormalCodeNum(codeBean) ? getMaxNormalCodeNum(
					codeBean).getSortNum()
					: 0);
			int sortNume = max + 1;
			String codeSortNum = CodeUtils.codeUtil.getInertCodeNum(
					codeBean.getCodeNum(), max);
			CodeBean newCodeEntity = new CodeBean.Builder()
					.codeFirst(codeBean.getCodeFirst())
					.codeSecond(codeBean.getCodeSecond())
					.codeThree(codeBean.getCodeThree())
					.codeFour(codeBean.getCodeFour())
					.codeFive(codeBean.getCodeFive())
					.codeSix(codeBean.getCodeSix())
					.codeNum(codeBean.getCodeNum()).createDate(codeBean.getCreateDate()).createTime(codeBean.getCreateTime()).createTimestamp(codeBean.getCreateTimestamp())
					.status(NORMAL_STATUS)
					.sortNum(sortNume)
					.codeSortNum(codeSortNum)
					.code(CodeUtils.codeUtil.getCode(new CodeBean.Builder()
							.codeFirst(codeBean.getCodeFirst())
							.codeSecond(codeBean.getCodeSecond())
							.codeThree(codeBean.getCodeThree())
							.codeFour(codeBean.getCodeFour())
							.codeFive(codeBean.getCodeFive())
							.codeSix(codeBean.getCodeSix())
							.codeSortNum(codeSortNum).build()))
					.codeId(CodeUtils.pkUtil.getUuid()).build();
			saveCode(newCodeEntity);
			return newCodeEntity.getCode();
		} else {
			int min = getMinDeleteCode(codeEntity).getSortNum();
			String codeSortNum = CodeUtils.codeUtil.getDeleteMinCodeNum(
					codeBean.getCodeNum(), min);
			CodeBean updateCodeEntity = new CodeBean.Builder()
					.codeFirst(codeBean.getCodeFirst())
					.codeSecond(codeBean.getCodeSecond())
					.codeThree(codeBean.getCodeThree())
					.codeFour(codeBean.getCodeFour())
					.codeFive(codeBean.getCodeFive())
					.codeSix(codeBean.getCodeSix())
					.codeNum(codeBean.getCodeNum())
					.sortNum(min)
					.codeSortNum(codeSortNum)
					.code(CodeUtils.codeUtil.getCode(new CodeBean.Builder()
							.codeFirst(codeBean.getCodeFirst())
							.codeSecond(codeBean.getCodeSecond())
							.codeThree(codeBean.getCodeThree())
							.codeFour(codeBean.getCodeFour())
							.codeFive(codeBean.getCodeFive())
							.codeSix(codeBean.getCodeSix())
							.codeSortNum(codeSortNum).build()))
					.status(NORMAL_STATUS).build();
			updateCodeStatus(updateCodeEntity);
			return updateCodeEntity.getCode();

		}

	  //判断是否有删除的业务编码
	 /** codeBean.setStatus(DELETE_STATUS);
	  int count = getIsHaveDeleteCodeCount(codeBean);
	  if(count==0){
		   codeBean.setStatus(NORMAL_STATUS);
		   int max= (null!=getMaxNormalCodeNum(codeBean)?getMaxNormalCodeNum(codeBean).getSortNum():0);
		   codeBean.setSortNum(max+1);
           codeBean.setCodeSortNum(CodeUtils.codeUtil.getInertCodeNum(codeBean.getCodeNum(), max));
           codeBean.setCode(CodeUtils.codeUtil.getCode(codeBean));
           codeBean.setCodeId(CodeUtils.pkUtil.getUuid());
           saveCode(codeBean);
	  }else{
		  codeBean.setStatus(DELETE_STATUS);
		  int min =getMinDeleteCode(codeBean).getSortNum();
		  codeBean.setSortNum(min);
		  codeBean.setCodeSortNum(CodeUtils.codeUtil.getDeleteMinCodeNum(codeBean.getCodeNum(), min));
		  codeBean.setCode(CodeUtils.codeUtil.getCode(codeBean));
		  codeBean.setStatus(NORMAL_STATUS);
		  updateCodeStatus(codeBean);
	  }
	  System.out.println(codeBean.getCode());
	  
	  return codeBean.getCode();*/
	}
	
	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#deleteCodeByCodeBean(com.ss.code.bean.CodeBean)
	 */
	@Override
	public int deleteCodeByCodeBean(CodeBean codeBean) throws Exception{
		if(null !=codeBean){
			//codeBean.setStatus(DELETE_STATUS);
			CodeBean codeEntity  =new CodeBean.Builder().status(DELETE_STATUS).code(codeBean.getCode()).build();
			if(!CodeUtils.codeUtil.isBlank(codeBean.getCode())){
				return updateCodeStatus(codeEntity);
			}
		}
		
		return 0;
		
	}

	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#deleteCodeByCode(java.lang.String)
	 */
	@Override
	public int deleteCodeByCode(String code) throws Exception {
		CodeBean codeEntity =  new CodeBean.Builder().code(code).build();
		if(!CodeUtils.codeUtil.isBlank(code)){
			return deleteCodeByCodeBean(codeEntity);
		}
		/**CodeBean codeBean=null;
		if(!CodeUtils.codeUtil.isBlank(code)){
			 codeBean =new CodeBean();
			codeBean.setCode(code);
			return deleteCodeByCodeBean(codeBean);
		}*/
		return 0;
		
	}
	
	/**
	 *(non-Javadoc)
	 * @see com.ss.code.service.ICodeService#delteCodeById(com.ss.code.bean.CodeBean)
	 */
	public   int   delteCodeById(CodeBean code) throws Exception{
		
		 return codeDao.getSqlSession().delete("code.delteCodeById",code);
	}
	
	public List<Map<String,Object>>  getAdvancedSearch(Map<String,Object>  map )  throws Exception{
		return codeDao.getSqlSession().selectList("code.getAdvancedSearch",map);
	}
	
	
	
	
	

}
