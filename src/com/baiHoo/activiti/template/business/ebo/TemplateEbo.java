package com.baiHoo.activiti.template.business.ebo;

import java.io.InputStream;

import org.springframework.transaction.annotation.Transactional;

import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.utils.base.BaseEbo;

@Transactional
public interface TemplateEbo extends BaseEbo<TemplateModel>{
	/**
	 * 
	 * @param tm  templateModel 必须是参数完整的类
	 * @return
	 */
	public InputStream downloadDoc(TemplateModel tm);

	public TemplateModel findTemplateByUuid(Integer templateUuid);

}
