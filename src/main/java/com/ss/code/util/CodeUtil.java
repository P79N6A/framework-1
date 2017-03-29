/**  <p>.</p> */
package com.ss.code.util;

import com.ss.code.bean.CodeBean;

/**
 * <p> CodeSqlUtil.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * Nov 14, 2014: 4:40:11 PM
 */
public class CodeUtil {
    final static String SPLIT_CHAR="_";
	
	CodeUtil(){
		
	}
	
	/**
	 *<p>Description: 根据codeBean构建B_CODE  .</p> 
	 *<p>@param codeBean
	 *<p>@return String
	 *@since Nov 15, 2014: 1:05:52 PM
	 *@author xubin
	 *@version 1.0
	 */
	public   String getCode(CodeBean codeBean){
		StringBuffer code  =new StringBuffer() ;
		if( null!=codeBean.getCodeFirst()){
			code.append(codeBean.getCodeFirst());
			code.append(SPLIT_CHAR);
		} if(!isBlank(codeBean.getCodeSecond())){
			code.append(codeBean.getCodeSecond());
			code.append(SPLIT_CHAR);
		} if(!isBlank(codeBean.getCodeThree())){
			code.append(codeBean.getCodeThree());
			code.append(SPLIT_CHAR);
		} if(!isBlank(codeBean.getCodeFour())){
			code.append(codeBean.getCodeFour());
			code.append(SPLIT_CHAR);
		} if(!isBlank(codeBean.getCodeFive())){
			code.append(codeBean.getCodeFive());
			code.append(SPLIT_CHAR);
		} if(!isBlank(codeBean.getCodeSix())){
			code.append(codeBean.getCodeSix());
			code.append(SPLIT_CHAR);
		} if(!isBlank(codeBean.getCodeSortNum())){
			code.append(codeBean.getCodeSortNum());
		}
		return code.toString();
	}
	
	/**
	 *<p>Description: 判断字符串是否为空    null return true .</p> 
	 *<p>@param cs
	 *<p>@return boolean
	 *@since Nov 14, 2014: 1:39:04 PM
	 *@author xubin
	 *@version 1.0
	 */
	public   boolean isBlank(CharSequence cs) {
		if (null == cs) {
			return true;
		}
		int length = cs.length();
		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 *<p>Description:根据sortNum和codeNum生成插入时的B_CODE 比如00000,1生成00002 .</p> 
	 *<p>@param code_num
	 *<p>@param sortNum
	 *<p>@return String
	 *@since Nov 14, 2014: 1:39:04 PM
	 *@author xubin
	 *@version 1.0
	 */
	public    String getInertCodeNum(String code_num,int sortNum)  {
		if(sortNum==0 && code_num.length()>0){
			return (code_num.substring(0, code_num.length()-1))+(sortNum+1);
		}
		if(sortNum>0 &&(sortNum+"").length()<=code_num.length()){
			int length =code_num.length()-((sortNum+1)+"").length() ;
			return (code_num.substring(0,length)==null?sortNum+1+"":(code_num.substring(0,length))+(sortNum+1));
		}
		if((sortNum+"").length()>code_num.length()){
		  //throw new Exception("序列【"+sortNum+"】超过最大位数"+"【"+code_num+"】");
		}
		return null ;
	
	 }
	
	/**
	 *<p>Description:根据sortNum和codeNum生成删除时的B_CODE 比如00000,1生成00001  .</p> 
	 *<p>@param code_num
	 *<p>@param sortNum
	 *<p>@return String
	 *@since Nov 20, 2014: 11:26:06 AM
	 *@author xubin
	 *@version 1.0
	 */
	public   String getDeleteMinCodeNum(String code_num,int sortNum)  {
		
		if(sortNum>0 &&(sortNum+"").length()<=code_num.length()){
			int length =code_num.length()-((sortNum)+"").length() ;
			return (code_num.substring(0,length)==null?sortNum+1+"":(code_num.substring(0,length))+(sortNum));
		}
		if((sortNum+"").length()>code_num.length()){
		  //throw new Exception("序列【"+sortNum+"】超过最大位数"+"【"+code_num+"】");
		}
		return null ;
	
	 }
	
//	public static void main(String args[]) {
//		
//		System.out.println(getDeleteMinCodeNum("000000",1));
//	}

	

	
	

}
