package com.baiHoo.activiti.user.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.baiHoo.activiti.user.dao.dao.UserDao;
import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.activiti.user.vo.UserQueryModel;
import com.baiHoo.utils.base.BaseImpl;
import com.baiHoo.utils.base.BaseQueryModel;
@SuppressWarnings("all")
public class UserImpl extends BaseImpl<UserModel> implements UserDao{

	public void doQueryDetachedCriteria(DetachedCriteria dc,BaseQueryModel qm){
		UserQueryModel uqm = (UserQueryModel)qm;
	}

	@Override
	public UserModel login(String userName, String password) {
		String hql = "FROM UserModel WHERE userName=? AND password=?";
		List<UserModel> temp = this.getHibernateTemplate().find(hql,userName , password);
		return (temp!=null && temp.size()!=0 && temp.get(0)!=null ? temp.get(0) : null);
	}

	@Override
	public Boolean updateUser(UserModel um) {
		try{
			this.getHibernateTemplate().update(um);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean deleteUser(UserModel um) {
		try{
			this.getHibernateTemplate().delete(um);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
