package com.ss.permission.security.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.ss.permission.security.service.ISecurityMetadataSource;
import com.ss.permission.security.service.ISecurityService;

/**
 * <p> SecurityMetadataSource.java.</p>
 * <p>Description: 自定义资源权限关系集合 <br> 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 此类在初始化时，应该取到所有资源及其对应角色的定义<br>
 *                  资源源数据定义，将所有的资源和权限对应关系建立起来，即定义某一资源可以被哪些角色去访问.</p>
 * <p>Company: .</p>
 * <p>@author xubin</p>
 * <p>@version .</p>
 * 2014-9-4: 上午10:41:32
 */
//@Service("securityMetadataSource")
public class SecurityMetadataSource implements ISecurityMetadataSource {
	
	
    /**  <p> 匹配规则  .</p> */
    private RequestMatcher requestMatcher;
    
    /**  <p>过期标识.</p> */
    private boolean expire = false;  
    /**  <p>规则标识 .</p> */
    private String matcher; 
    /** 保存资源和权限的对应关系  key-资源url  value-权限 */  
    private static Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
	@Resource
	public ISecurityService securityService;
	
    @PostConstruct	
	public void init() throws Exception {
    	load();
	}
    
    private void load() throws Exception {
    	//if(null ==resourceMap || resourceMap.isEmpty()){
    		resourceMap=securityService.getResourcesAuthority();
    	//}
    	
    }
    
    private void refresh(){
    	
    }

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> attributes = new HashSet<ConfigAttribute>();
		for (Map.Entry<String, Collection<ConfigAttribute>> entry : resourceMap.entrySet()) {
			attributes.addAll(entry.getValue());
		}
		return attributes;
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		HttpServletRequest request = ((FilterInvocation) object).getRequest();
		System.out.println("requestUrl is ==========:"+request.getRequestURI());
//		String requestUrl = ((FilterInvocation) object).getRequestUrl();
//		System.out.println("requestUrl is ==========:"+requestUrl);
		if(isExpire()){
			resourceMap.clear();
			expire=false;
		}
		if(null == resourceMap || resourceMap.isEmpty()){
			try {
				this.load();
			} catch (Exception e) {
				
			}
		}
		 // 检测请求与当前资源匹配的正确性  
        Iterator<String> iterator = resourceMap.keySet().iterator();  
        while (iterator.hasNext()) {  
            String uri = iterator.next();  
            if (matcher.toLowerCase().equals("ant")) {  
                requestMatcher = new AntPathRequestMatcher(uri);  
            }  
            if (matcher.toLowerCase().equals("regex")) {  
                requestMatcher = new RegexRequestMatcher(uri, request.getMethod(), true);  
            }  
            if (requestMatcher.matches(request))  
                return resourceMap.get(uri);  
        }  
        
        return null;
        
//		if(requestUrl.indexOf("?")>-1){
//			requestUrl=requestUrl.substring(0,requestUrl.indexOf("?"));
//		}
//		return resourceMap.get(requestUrl);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	public boolean isExpire() {
		return expire;
	}
	
	public void setMatcher(String matcher) {
		this.matcher = matcher;
	}

}
