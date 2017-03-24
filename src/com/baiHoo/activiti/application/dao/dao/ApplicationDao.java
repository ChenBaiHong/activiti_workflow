package com.baiHoo.activiti.application.dao.dao;

import java.util.List;

import com.baiHoo.activiti.application.vo.ApplicationModel;
import com.baiHoo.activiti.application.vo.ApplicationQueryModel;
import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.utils.base.BaseDao;

public interface ApplicationDao extends BaseDao<ApplicationModel> {
	public List<ApplicationModel> getAllByLoginUser(ApplicationQueryModel aqm,
			UserModel login, Integer currentPage, Integer pageDataCount);

	public Integer getCount(ApplicationQueryModel aqm, UserModel login);

}
