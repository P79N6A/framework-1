/**  <p>.</p> */
package com.ss.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.framework.dto.SessionUser;
import com.framework.util.StringUtils;
import com.framework.web.controller.BaseController;

/**
 * <p> LoginController.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年5月3日: 上午11:43:30
 */
@Controller
@RequestMapping("/xb_default")
public class LoginController extends BaseController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public SessionUser login(@RequestParam(required=true,value="username") String userName,@RequestParam(required=true,value="password") String password) throws Exception{
		SessionUser sessionUser = this.getSessionUser();
		if(null== sessionUser && (!StringUtils.isBlank(userName)&& !StringUtils.isBlank(password))){
			sessionUser=authUserAccount(userName, password);
			if(null==sessionUser){
				
			}else{
				setUserInSession(sessionUser);
			}
		}
		return sessionUser;
	}
	
	 public  SessionUser authUserAccount(String userName, String password) {
		return null;
	}
	
	

	

	

}
