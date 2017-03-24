package com.baiHoo.activiti.processDefinition.business.ebo;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProcessDefinitionEbo {
	/**
	 * 查询最新版本的流程定义列表
	 * @return 
	 */
	public List<ProcessDefinition> findNewVsionList();
	/**
	 * 部署流程定义文件
	 * @param resource
	 */
	public void deploy(File resource);
	/**
	 * 查找该流程定义的流程图
	 * @param id
	 * @return
	 */
	public InputStream findProcessPicture(String id);

}
