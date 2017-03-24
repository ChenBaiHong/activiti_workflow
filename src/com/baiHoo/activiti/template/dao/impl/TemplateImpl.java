package com.baiHoo.activiti.template.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.baiHoo.activiti.template.dao.dao.TemplateDao;
import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.activiti.template.vo.TemplateQueryModel;
import com.baiHoo.utils.base.BaseImpl;
import com.baiHoo.utils.base.BaseQueryModel;
@SuppressWarnings("all")
public class TemplateImpl extends BaseImpl<TemplateModel> implements TemplateDao{

	
	public void doQueryDetachedCriteria(DetachedCriteria dc,BaseQueryModel qm){
		TemplateQueryModel tqm = (TemplateQueryModel)qm;
		// TODO 添加自定义查询条件
	}

	@Override
	public TemplateModel findTemplateByUuid(Integer templateUuid) {
		String hql = "FROM TemplateModel WHERE uuid=?";
		List<TemplateModel> temp = this.getHibernateTemplate().find(hql,templateUuid);
		return temp!=null && temp.size()!=0? temp.get(0) : null;
	}

}
