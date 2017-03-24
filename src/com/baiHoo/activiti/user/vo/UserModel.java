package com.baiHoo.activiti.user.vo;

import java.io.Serializable;

/**
 * 注册用户基本信息
 * 
 * @author 陈柏宏
 *
 */
public class UserModel implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String USER_LOGIN_VARIABLE="userModel"; 
	
	private Integer uuid;				//唯一识别id
	private String name;				//用户真实名称
	private String userName;			//用户昵称
	private String password;			//用户密码
	private String email;				//用户邮箱
	private String tele;				//用户电话
	
	public UserModel() {
		super();
	}

	public UserModel(Integer uuid, String name, String userName, String password, String email, String tele) {
		super();
		this.uuid = uuid;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.tele = tele;
	}

	public Integer getUuid() {
		return uuid;
	}

	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
	
	
}
