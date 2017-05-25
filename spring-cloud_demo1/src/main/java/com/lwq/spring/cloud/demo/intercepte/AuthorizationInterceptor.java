package com.lwq.spring.cloud.demo.intercepte;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lwq.spring.cloud.demo.annotation.Auth;

/**
 * 
* @ClassName: AuthorizationInterceptor
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lwq
* @date 2017年5月25日 下午12:46:40
*  拦截器
 */
public class AuthorizationInterceptor  extends  HandlerInterceptorAdapter {
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//基于方法拦截

		//如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth methodAnnotation = handlerMethod.getMethodAnnotation(Auth.class);
        if(methodAnnotation==null){
        	ServletOutputStream outputStream = response.getOutputStream();
        	outputStream.write("授权失败".getBytes());
        	 //授权失败
        	return false;
        	
        }else{
        	return true; //授权成功
        	
        }
        
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}


}
