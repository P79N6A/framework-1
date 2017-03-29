/**  <p>.</p> */
package com.framework.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * <p> DispatcherEncodingServlet.java.</p>
 * <p>Description:  .</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2017年3月22日: 下午12:09:34
 */
public class DispatcherEncodingServlet extends DispatcherServlet {

	/**  <p>.</p> */
	private static final long serialVersionUID = 3785502080514655877L;
	
	public String encoding;
	/**
	 * 
	 *(non-Javadoc)
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig config)  throws ServletException{
		this.encoding=config.getInitParameter("encoding");
		super.init(config);
	}
	
	/**
	 *(non-Javadoc)
	 * @see org.springframework.web.servlet.DispatcherServlet#doService(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doService(HttpServletRequest request,HttpServletResponse response)  throws Exception{
		super.doService(request, response);
	}
	
	

}
