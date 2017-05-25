package com.lwq.spring.cloud.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/***
 * 
* @ClassName: Auth
* @Description: TODO(这里用一句话描述这个类的作用) 方法拦截器
* @author lwq
* @date 2017年5月25日 下午12:50:23
*
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	 String value() default ""; //默认值

}
