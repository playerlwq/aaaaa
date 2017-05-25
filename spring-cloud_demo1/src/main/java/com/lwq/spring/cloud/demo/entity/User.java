package com.lwq.spring.cloud.demo.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.lwq.spring.cloud.demo.base.BaseEntity;

/**
 * 
* @ClassName: User
* @Description: TODO(这里用一句话描述这个类的作用)
* @author lwq
* @date 2017年5月18日 下午4:06:28
*
 */

public class User extends BaseEntity {

	
	private String uname; //用户名
	
	private String upass; //密码
	
	@JSONField(format="yyyy-MM-dd mm:ss")
	private Date createTime; //登录时间
	@JSONField(format="yyyy-MM-dd mm:ss")
	private Date loginTime; //注册时间
	
	private String loginIp; //上次登录ip
	
	private String  secretKey; //秘钥

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String uname, String upass, Date createTime, Date loginTime,
			String loginIp, String secretKey) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.createTime = createTime;
		this.loginTime = loginTime;
		this.loginIp = loginIp;
		this.secretKey = secretKey;
	}
	
	
	
	
}
