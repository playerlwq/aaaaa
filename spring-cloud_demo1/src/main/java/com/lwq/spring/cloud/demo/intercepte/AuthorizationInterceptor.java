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
* @Description: TODO(������һ�仰��������������)
* @author lwq
* @date 2017��5��25�� ����12:46:40
*  ������
 */
public class AuthorizationInterceptor  extends  HandlerInterceptorAdapter {
	
	/**
	 * This implementation always returns {@code true}.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//���ڷ�������

		//�������ӳ�䵽����ֱ��ͨ��
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth methodAnnotation = handlerMethod.getMethodAnnotation(Auth.class);
        if(methodAnnotation==null){
        	ServletOutputStream outputStream = response.getOutputStream();
        	outputStream.write("��Ȩʧ��".getBytes());
        	 //��Ȩʧ��
        	return false;
        	
        }else{
        	return true; //��Ȩ�ɹ�
        	
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
