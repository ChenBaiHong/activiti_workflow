package com.baiHoo.activiti.application.business.ebo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.baiHoo.activiti.application.vo.ApplicationModel;
import com.baiHoo.activiti.application.vo.ApplicationQueryModel;
import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.utils.base.BaseEbo;

@Transactional
public interface ApplicationEbo extends BaseEbo<ApplicationModel>{
	/**
	 * 提交申请
	 * @param login 					申请人
	 * @param temolateModel  申请使用的模板
	 * @param docFilePath		申请的doc文档
	 */
	public void submitApp(UserModel login, TemplateModel temolateModel,
			String docFilePath);
	/**
	 * 获取当前登录人的申请信息
	 * @param aqm
	 * @param login
	 * @param currentPage
	 * @param pageDataCount
	 * @return
	 */
	public List<ApplicationModel> getAllByLoginUser(ApplicationQueryModel aqm,
			UserModel login, Integer currentPage, Integer pageDataCount);
	/**
	 * 获取当前登录人的申请记录数
	 * @param aqm
	 * @param login
	 * @return
	 */
	public Integer getCount(ApplicationQueryModel aqm, UserModel login);
}
