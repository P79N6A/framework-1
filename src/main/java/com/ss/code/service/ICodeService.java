/**  <p>.</p> */
package com.ss.code.service;

import java.util.List;
import java.util.Map;

import com.ss.code.bean.CodeBean;

/**
 * <p> ICodeService.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Nov 11, 2014: 5:39:42 PM
 */
public interface ICodeService {
	
	
	/**
	 *<p>Description: 获取业务编码是正常状态下 sortnum 最大的codeBean.</p> 
	 *<p>@param codeBean
	 *<p>@return
	 *<p>@throws Exception CodeBean
	 *@since Nov 20, 2014: 2:09:20 PM
	 *@author xubin
	 *@version 1.0
	 */
     CodeBean  getMaxNormalCodeNum(CodeBean codeBean) throws Exception ;
	/**
	 *<p>Description:保存业务编码  .</p> 
	 *<p>@param codeBean
	 *<p>@throws Exception void
	 *@since Nov 20, 2014: 2:09:23 PM
	 *@author xubin
	 *@version 1.0
	 */
	 void saveCode(CodeBean codeBean) throws Exception;
	/**
	 *<p>Description:更新业务编码状态  .</p> 
	 *<p>@param codeBean
	 *<p>@throws Exception void
	 *@since Nov 20, 2014: 2:09:26 PM
	 *@author xubin
	 *@version 1.0
	 */
	 int updateCodeStatus(CodeBean codeBean) throws Exception;
	 /**
	 *<p>Description:获取删除的业务编码数量   .</p> 
	 *<p>@param codeBean
	 *<p>@return
	 *<p>@throws Exception Integer
	 *@since Nov 20, 2014: 2:24:19 PM
	 *@author xubin
	 *@version 1.0
	 */
	 long  getIsHaveDeleteCodeCount(CodeBean codeBean) throws Exception;
	/**
	 *<p>Description: 获取删除业务编码中业务编码最小的 .</p> 
	 *<p>@param codeBean
	 *<p>@return
	 *<p>@throws Exception CodeBean
	 *@since Nov 20, 2014: 2:26:03 PM
	 *@author xubin
	 *@version 1.0
	 */
	CodeBean  getMinDeleteCode(CodeBean codeBean) throws Exception;
	/**
	 *<p>Description: 根据传入的codeBean生成业务编码规则  <P>
                                                                  如果存在作废的业务编码则返回作废编码中最小的业务编码;<P>
	 *                如果不存在作废的业务编码则返回编码中最大的业务编码  如0001 返回0002 .</p> 
	 *<p>@param codeBean
	 *<p>@return
	 *<p>@throws Exception String
	 *@since Nov 20, 2014: 2:09:29 PM
	 *@author xubin
	 *@version 1.0
	 */
	 String  saveCodeAndReturnCode(CodeBean codeBean) throws Exception;
	
	 /**
	 *<p>Description: 删除业务编码 .</p> 
	 *<p>@param codeBean
	 *<p>@return
	 *<p>@throws Exception int
	 *@since Nov 20, 2014: 2:46:48 PM
	 *@author xubin
	 *@version 1.0
	 */
	int  deleteCodeByCodeBean(CodeBean codeBean) throws Exception;
	
	/**
	 *<p>Description:删除业务编码  .</p> 
	 *<p>@param code
	 *<p>@return
	 *<p>@throws Exception int
	 *@since Nov 20, 2014: 2:47:59 PM
	 *@author xubin
	 *@version 1.0
	 */
	int  deleteCodeByCode(String code) throws Exception;
	
	/**
	 *<p>Description:  .</p> 
	 *<p>@param code
	 *<p>@return
	 *<p>@throws Exception int 
	 */
	int   delteCodeById(CodeBean code) throws Exception;
	
	public List<Map<String,Object>>   getAdvancedSearch(Map<String,Object>  map )  throws Exception;
	public  List<CodeBean> getAllList(CodeBean code) throws Exception;

}
