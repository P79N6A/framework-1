/**  <p>.</p> */
package com.ss.code.bean;

import java.io.Serializable;

/**
 * 
 * <p> CodeBean.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年3月25日: 下午7:43:57
 */
public class CodeBean implements Serializable {
	
	/**  <p>.</p> */
	private static final long serialVersionUID = 5506348102109428303L;

	private CodeBean(){
		
	}
	
	/**
	 * <p>
	 * 主键.
	 * </p>
	 */
	private   String codeId;
	/**
	 * <p>
	 * 业务编码.
	 * </p>
	 */
	private   String code;
	/**
	 * <p>
	 * 序列.
	 * </p>
	 */
	private  int sortNum;
	/**
	 * <p>
	 * 第一个前缀.
	 * </p>
	 */
	private  String codeFirst;
	
	private  String codeSecond;
	
	private   String codeThree;
	
	private   String codeFour;
	
	private   String codeFive;
	
	private   String codeSix;

	/**
	 * <p>
	 * 编码位数.
	 * </p>
	 */
	private   String codeNum;
	/**
	 * <p>
	 * 状态是否删除 1正常 0 删除.
	 * </p>
	 */
	private  String status;

	/**
	 * <p>
	 * sort num.
	 * </p>
	 */
	private  String codeSortNum;
	
	private java.sql.Timestamp createTimestamp;
	private java.util.Date createDate;
	private java.util.Date createTime;

	private CodeBean(Builder builder) {
		createDate= builder.createDate;
		createTime= builder.createTime;
		createTimestamp = builder.createTimestamp;
		codeId = builder.codeId;
		code = builder.code;
		sortNum = builder.sortNum;
		codeFirst = builder.codeFirst;
		codeSecond = builder.codeSecond;
		codeThree = builder.codeThree;
		codeFour = builder.codeFour;
		codeFive = builder.codeFive;
		codeSix = builder.codeSix;
		codeNum = builder.codeNum;
		status = builder.status;
		codeSortNum = builder.codeSortNum;
		
		
	
	}

	public static class Builder {
		
		private  String codeId;
		
		private String code;
		
		private int sortNum;
	
		private  String codeFirst;
		
		private String codeSecond;
		
		private String codeThree;
		
		private String codeFour;
		
		private String codeFive;
		
		private String codeSix;

		private  String codeNum;
		
		private String status;
		
		private  String codeSortNum;
		private java.sql.Timestamp createTimestamp;
		private java.util.Date createDate;
		private java.util.Date createTime;
		
		
		/**
		 *<p>Description:  .</p> 
		 *<p>@return CodeEntity
		 *@since Dec 2, 2014: 10:44:29 AM
		 *@author xubin
		 *@version 1.0
		 */
		public CodeBean build(){
			return new CodeBean(this);
		}
		/**
		 * @param codeFirst
		 * @param codeNum
		 */
		public Builder () {
			
		}
		
		public Builder codeNum(String codeNum){
			this.codeNum =codeNum;
			return this;
		}
		
		public Builder codeFirst(String codeFirst){
			this.codeFirst =codeFirst;
			return this;
		}
		
		public Builder codeId(String codeId){
			this.codeId =codeId;
			return this;
		}
		public Builder code(String code){
			this.code =code;
			return this;
		}
		public Builder sortNum(int sortNum){
			this.sortNum =sortNum;
			return this;
		}
		public Builder codeSecond(String codeSecond){
			this.codeSecond =codeSecond;
			return this;
		}
		public Builder codeThree(String codeThree){
			this.codeThree =codeThree;
			return this;
		}
		public Builder codeFour(String codeFour){
			this.codeFour =codeFour;
			return this;
		}
		public Builder codeFive(String codeFive){
			this.codeFive =codeFive;
			return this;
		}
		public Builder codeSix(String codeSix){
			this.codeSix =codeSix;
			return this;
		}
		public Builder status(String status){
			this.status =status;
			return this;
		}
		
		public Builder codeSortNum(String codeSortNum){
			this.codeSortNum =codeSortNum;
			return this;
		}
		
		public Builder createTimestamp(java.sql.Timestamp createTimestamp){
			this.createTimestamp =createTimestamp;
			return this;
		}
		public Builder createDate(java.util.Date createDate ){
			this.createDate =createDate;
			return this;
		}
		public Builder createTime(java.util.Date createTime){
			this.createTime =createTime;
			return this;
		}
		
	
		

	}

	public String getCodeId() {
		return codeId;
	}

	

	public String getCode() {
		return code;
	}

	

	public int getSortNum() {
		return sortNum;
	}

	
	public String getCodeFirst() {
		return codeFirst;
	}

	

	public String getCodeSecond() {
		return codeSecond;
	}

	

	public String getCodeThree() {
		return codeThree;
	}

	

	public String getCodeFour() {
		return codeFour;
	}

	

	public String getCodeFive() {
		return codeFive;
	}

	

	public String getCodeSix() {
		return codeSix;
	}

	

	public String getCodeNum() {
		return codeNum;
	}

	

	public String getStatus() {
		return status;
	}

	

	public String getCodeSortNum() {
		return codeSortNum;
	}


//=======================================================
	public java.sql.Timestamp getCreateTimestamp() {
		return createTimestamp;
	}



	public java.util.Date getCreateDate() {
		return createDate;
	}


	public java.util.Date  getCreateTime() {
		return createTime;
	}

	

	

}
