package com.ss.service.test;


import java.util.List;

import com.framework.test.SpringBeanUtil;
import com.ss.code.bean.CodeBean;
import com.ss.code.service.ICodeService;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CodeServiceTest extends TestCase {
	
public  ICodeService codeService;
	
	public CodeServiceTest(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}

	protected void setUp()throws Exception{
		codeService =(ICodeService) SpringBeanUtil.getBean("codeService");
	}
	
	public static junit.framework.Test suite(){
		return  new TestSuite(CodeServiceTest.class);
	}
	

//	public void testGetIsHaveDeleteCode() {
//		
//	}

//	public void testGetInsertHaveNotDeleteCodeNum() {
//	}

	public void testSaveCode()throws Exception {
//		CodeBean codeBean = new CodeBean();
//		codeBean.setCodeFirst("ITRS");
//		codeBean.setCodeSecond("02");
//		codeBean.setCodeThree("03");
//		codeBean.setCodeNum("00000000");
//		codeService.saveCodeAndReturnCode(new CodeBean.Builder()
//				.codeNum("00").createDate(new Date()).createTime(new Date()).createTimestamp(new Timestamp(System.currentTimeMillis())).build());
	}
	
	public void testGetAllList() throws Exception{
		CodeBean codeBean = null;
		List<CodeBean>  list =  codeService.getAllList(codeBean);
	}

//	public void testUpdateCodeStatus() {
//	}

}
