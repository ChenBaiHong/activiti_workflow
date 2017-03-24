package com.baiHoo.activiti.user.business.ebi;

import java.io.Serializable;
import java.util.List;

import com.baiHoo.activiti.user.business.ebo.UserEbo;
import com.baiHoo.activiti.user.dao.dao.UserDao;
import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.utils.base.BaseQueryModel;
import com.baiHoo.utils.format.MD5Utils;

public class UserEbi implements UserEbo{
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void save(UserModel um) {
		um.setPassword(MD5Utils.md5(um.getPassword()));
		userDao.save(um);
	}

	public void update(UserModel um) {
		UserModel temp=userDao.get(um.getUuid());
		temp.setEmail(um.getEmail());
		temp.setName(um.getName());
		temp.setTele(um.getTele());
		temp.setUserName(um.getUserName());
	}

	public void delete(UserModel um) {
		userDao.delete(um);
	}

	public UserModel get(Serializable uuid) {
		return userDao.get(uuid);
	}

	public List<UserModel> getAll() {
		return userDao.getAll();
	}

	public List<UserModel> getAll(BaseQueryModel qm, Integer currentPage,Integer pageDataCount) {
		return userDao.getAll(qm, currentPage, pageDataCount);
	}

	public Integer getCount(BaseQueryModel qm) {
		return userDao.getCount(qm);
	}
	public UserModel login(String userName, String password) {
		password = MD5Utils.md5(password);
		return userDao.login(userName,password) ;
	}

	public Boolean updateUser(UserModel um) {
		
		return userDao.updateUser(um);
	}

	@Override
	public Boolean deleteUser(UserModel um) {
		return userDao.deleteUser(um);
	}

}
