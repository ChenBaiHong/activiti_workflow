package com.baiHoo.activiti.user.business.ebo;

import org.springframework.transaction.annotation.Transactional;

import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.utils.base.BaseEbo;

@Transactional
public interface UserEbo extends BaseEbo<UserModel>{

	public UserModel login(String userName, String password);

	public Boolean deleteUser(UserModel um);
	
	public Boolean updateUser(UserModel um);
}
