package com.baiHoo.activiti.template.dao.dao;

import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.utils.base.BaseDao;

public interface TemplateDao extends BaseDao<TemplateModel> {

	public TemplateModel findTemplateByUuid(Integer templateUuid);

}
