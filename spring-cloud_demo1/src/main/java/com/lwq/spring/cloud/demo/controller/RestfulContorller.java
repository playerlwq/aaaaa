package com.lwq.spring.cloud.demo.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lwq.spring.cloud.demo.entity.User;
import com.lwq.spring.cloud.demo.utils.HttpRequestDeviceUtils;
import com.lwq.spring.cloud.demo.utils.IpUtils;
/***
 * 
* @ClassName: RestfulContorller
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lwq
* @date 2017年5月19日 下午1:56:13
*
 */
@RestController
@Controller
@RequestMapping("/user")
public class RestfulContorller {
	
		/**
		 * @athur:lwq
		* @Title: getUser
		* @Description: TODO(这里用一句话描述这个方法的作用)
		* @param @param user
		* @param @return    设定文件
		* @return User    返回类型
		* @throws
		 */
	  @RequestMapping(value = "/add/{username}/{upass}",method = RequestMethod.POST,consumes="application/json",produces={"application/jsom;charset=utf-8"})
	  @ResponseBody
	    public User addUser( User user){
		  user.setCreateTime(new Date());
		  user.setLoginTime(new Date());
		  //do..... valivate >< db
	        return  user;
	  }
	  /**
	   * 
	  * @Title: getUser
	  * @Description: TODO(这里用一句话描述这个方法的作用)
	  * @param @param username
	  * @param @param request
	  * @param @return    设定文件
	  * @return User    返回类型
	  * @throws
	   */
	  @RequestMapping(value = "/add/{username}",method = RequestMethod.GET)
	  @ResponseBody
	    public User getUser( @PathParam("username") String username,HttpServletRequest request){
		  boolean flag=HttpRequestDeviceUtils.isMobileDevice(request);
		  String isDevi="";
		  if(flag){
			  isDevi="device _visit";  
		  }else{
			  isDevi="PC_visit";  
			  
		  }
		  User user=new User();
		  user.setLoginIp(IpUtils.getIP() +"   _brows on: "+isDevi);
		  user.setUname(username);
		  user.setCreateTime(new Date());
		  user.setLoginTime(new Date());
		  user.setSecretKey(UUID.randomUUID().toString());
		  //do..... valivate >< db
	        return  user;
	  }
	  
	  
	  
	  
	  @RequestMapping(value = "/deteleUser/{username}",method = RequestMethod.DELETE)
	  @ResponseBody
	    public String  deteleUser( @PathParam("username") String username,HttpServletRequest request){
		 
	        return  "{msg: username "+username +" delete success ,code:succes}";
	  }
	  
	  
	  
	  
	  

	
}
