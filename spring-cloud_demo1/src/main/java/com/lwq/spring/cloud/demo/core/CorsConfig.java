package com.lwq.spring.cloud.demo.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 
* @ClassName: CorsConfig
* @Description: TODO(������һ�仰��������������)
* @author lwq
* @date 2017��5��24�� ����5:15:31
*  spring-boot ����������
 */
@Configuration
public class CorsConfig {

	
	private CorsConfiguration buildCorsConfiguration(){
		
		CorsConfiguration configuration=new CorsConfiguration();
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedOrigin("*");
		return configuration;
	}
	/**
	 * 
	* @Title: corsFilter
	* @Description: TODO(������һ�仰�����������������)
	* @param @return    �趨�ļ�
	* @return CorsFilter    ��������
	* @throws
	* ע��bean
	* 
	 */
	@Bean
	public CorsFilter  corsFilter (){
		UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildCorsConfiguration());;
		return new CorsFilter(source);
	}
}
