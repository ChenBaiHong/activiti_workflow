package com.baiHoo.activiti.application.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.baiHoo.activiti.application.dao.dao.ApplicationDao;
import com.baiHoo.activiti.application.vo.ApplicationModel;
import com.baiHoo.activiti.application.vo.ApplicationQueryModel;
import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.utils.base.BaseImpl;
import com.baiHoo.utils.base.BaseQueryModel;
@SuppressWarnings("all")
public class ApplicationImpl extends BaseImpl<ApplicationModel> implements ApplicationDao{

	public void doQueryDetachedCriteria(DetachedCriteria dc,BaseQueryModel qm){
		ApplicationQueryModel aqm = (ApplicationQueryModel)qm;
	}
	
	public void doQueryDetachedCriteria2(DetachedCriteria dc,BaseQueryModel qm , UserModel login){
		ApplicationQueryModel aqm = (ApplicationQueryModel)qm;
		// 添加排序条件
		dc.addOrder(Order.desc("applyDate"));
		dc.add(Restrictions.eq("applicant", login));// 添加过滤条件
		if (aqm.getStatus() != null && aqm.getStatus()> 0) {
			// 根据申请的状态过滤
			dc.add(Restrictions.eq("status", aqm.getStatus()));
		}
	}
	@Override
	public List<ApplicationModel> getAllByLoginUser(ApplicationQueryModel aqm,
			UserModel login, Integer currentPage, Integer pageDataCount) {
		DetachedCriteria dc = DetachedCriteria.forClass(ApplicationModel.class);
		doQueryDetachedCriteria2(dc, aqm ,  login);
		List<ApplicationModel> list = this.getHibernateTemplate().findByCriteria(dc ,(currentPage-1)*pageDataCount,pageDataCount);
		return list;
	}

	@Override
	public Integer getCount(ApplicationQueryModel aqm, UserModel login) {
		DetachedCriteria dc = DetachedCriteria.forClass(ApplicationModel.class);
		dc.setProjection(Projections.rowCount());
		doQueryDetachedCriteria2(dc, aqm ,  login);
		List<Long> count = this.getHibernateTemplate().findByCriteria(dc);
		return count.get(0).intValue();
	}

}
