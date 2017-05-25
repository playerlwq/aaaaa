package com.lwq.spring.cloud.demo.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 
* @ClassName: CorsConfig
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lwq
* @date 2017年5月24日 下午5:15:31
*  spring-boot 跨域问题解决
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
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param @return    设定文件
	* @return CorsFilter    返回类型
	* @throws
	* 注入bean
	* 
	 */
	@Bean
	public CorsFilter  corsFilter (){
		UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildCorsConfiguration());;
		return new CorsFilter(source);
	}
}
