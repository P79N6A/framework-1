/**  <p>.</p> */
package com.ss.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ss.code.bean.CodeBean;
import com.ss.code.service.ICodeService;

/**
 * <p> CodeController.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年3月29日: 下午2:54:32
 */
@Controller
@RequestMapping("/ss")
public class CodeController {
	@Autowired
	private ICodeService codeService;

	public ICodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(ICodeService codeService) {
		this.codeService = codeService;
	}
	
	
	@RequestMapping(value = "/getAllList", method = RequestMethod.GET)
	public @ResponseBody List<CodeBean> getAllList() throws Exception {
		CodeBean code = null;
		return codeService.getAllList(code);
	}

}
