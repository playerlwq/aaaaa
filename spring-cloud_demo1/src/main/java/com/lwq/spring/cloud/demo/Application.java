package com.lwq.spring.cloud.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.lwq.spring.cloud.demo.annotation.Auth;
import com.lwq.spring.cloud.demo.intercepte.AuthorizationInterceptor;
/**
 * 
* @ClassName: Application
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lwq
* @date 2017年5月18日 下午2:55:49
*
 */
@Controller
@SpringBootApplication
public class Application  extends WebMvcConfigurerAdapter{
	
	/**
	  *
	  * spring-boot 添加 fastjson 配置 默认是jackjson
	  * 
	  */
	 @Override
	 public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	 	super.configureMessageConverters(converters);
	 	
	     FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

	     FastJsonConfig fastJsonConfig = new FastJsonConfig();
	     fastJsonConfig.setSerializerFeatures(
	             SerializerFeature.PrettyFormat
	     );
	     fastConverter.setFastJsonConfig(fastJsonConfig);
	 	
	 	converters.add(fastConverter);
	 }

	
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
	
		 registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");//权限拦截器
		 
		 super.addInterceptors(registry);
	}
	 
	@ResponseBody
    @RequestMapping(value = "/")
	@Auth
    String home() {
        return "Hello World!lwq mmmmddsadasfdasfds";
    }
	
	 public static void main(String[] args) {
	        SpringApplication.run(Application.class, args);
	    }


}
