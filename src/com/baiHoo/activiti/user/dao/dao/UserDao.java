package com.baiHoo.activiti.user.dao.dao;

import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.utils.base.BaseDao;

public interface UserDao extends BaseDao<UserModel> {

	public UserModel login(String userName, String password);

	public Boolean updateUser(UserModel um);

	public Boolean deleteUser(UserModel um);

}
