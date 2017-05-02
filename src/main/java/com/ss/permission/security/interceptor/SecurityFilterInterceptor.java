/**  <p>.</p> */
package com.ss.permission.security.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.FilterInvocation;

import com.ss.permission.security.service.impl.SecurityAccessDecisionManager;
import com.ss.permission.security.service.impl.SecurityMetadataSource;



/**
 * <p> FilterSecurityInterceptor.java.</p>
 * <p>Description:  自定义认证管理,资源,权限 <br>资源源数据定义，将所有的资源和权限对应关系建立起来，即定义某一资源可以被哪些角色访问.</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2014-8-15: 下午2:58:41
 */

public class SecurityFilterInterceptor extends AbstractSecurityInterceptor implements Filter {
	//@Autowired
	private SecurityMetadataSource  securityMetadataSource;
	//@Autowired
	private SecurityAccessDecisionManager  accessDecisionManager ;
	//@Autowired
	private AuthenticationManager authenticationManager; 
	
	
	/**
	 * 
	 *<p>Description:初始化 .</p> 
	 *<p> void
	 *@since Sep 15, 2014: 2:51:18 PM
	 *@author xubin
	 *@version 1.0
	 */
	//@PostConstruct
	public  void init() {
		super.setAuthenticationManager(authenticationManager);
		super.setAccessDecisionManager(accessDecisionManager);
	}
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#obtainSecurityMetadataSource()
	 */
	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return securityMetadataSource;
	}
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		FilterInvocation filterInvocation = new FilterInvocation(request,response, chain);
		invoke(filterInvocation);

	}

	

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.intercept.AbstractSecurityInterceptor#getSecureObjectClass()
	 */
	@Override
	public Class<? extends Object> getSecureObjectClass() {
		//下面的MyAccessDecisionManager的supports方面必须放回true,否则会提醒类型错误
		return FilterInvocation.class;
	}
    
	/**
	 *<p>Description: object为FilterInvocation对象  super.beforeInvocation(fi);<br>
	 *1.获取请求资源的权限 :<br>
	 *执行Collection<ConfigAttribute> attributes = SecurityMetadataSource.getAttributes(object)<br>
	 *2.是否拥有权限 <br>
	 *this.accessDecisionManager.decide(authenticated, object, attributes) .</p> 
	 *<p>@param fi
	 *<p>@throws IOException
	 *<p>@throws ServletException void
	 *@since Sep 15, 2014: 2:53:29 PM
	 *@author xubin
	 *@version 1.0
	 */
	private void invoke(FilterInvocation fi) throws IOException,
			ServletException {

		InterceptorStatusToken token = super.beforeInvocation(fi);

		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}

	}

}
