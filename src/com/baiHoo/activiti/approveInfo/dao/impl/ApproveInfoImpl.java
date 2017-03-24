package com.baiHoo.activiti.approveInfo.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.baiHoo.activiti.approveInfo.dao.dao.ApproveInfoDao;
import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.activiti.approveInfo.vo.ApproveInfoQueryModel;
import com.baiHoo.utils.base.BaseImpl;
import com.baiHoo.utils.base.BaseQueryModel;
@SuppressWarnings("all")
public class ApproveInfoImpl extends BaseImpl<ApproveInfoModel> implements ApproveInfoDao{

	public void doQueryDetachedCriteria(DetachedCriteria dc,BaseQueryModel qm){
		ApproveInfoQueryModel aqm = (ApproveInfoQueryModel)qm;
		// TODO 添加自定义查询条件
	}

	public List<ApproveInfoModel> findListByApplicationId(Integer applicationId) {
		//String hql = "FROM ApproveInfoModel aim WHERE aim.am.uuid = ? ORDER BY aim.approveDate ASC";
		String hql = "FROM ApproveInfoModel WHERE am.uuid=? ORDER BY approveDate ASC";
		return this.getHibernateTemplate().find(hql,applicationId);
	}

}
