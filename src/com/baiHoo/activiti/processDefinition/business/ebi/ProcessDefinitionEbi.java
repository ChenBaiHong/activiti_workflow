package com.baiHoo.activiti.processDefinition.business.ebi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import com.baiHoo.activiti.processDefinition.business.ebo.ProcessDefinitionEbo;

public class ProcessDefinitionEbi implements ProcessDefinitionEbo{
	
		private ProcessEngine processEngine;
		public void setProcessEngine(ProcessEngine processEngine) {
			this.processEngine = processEngine;
		}
		
		public List<ProcessDefinition> findNewVsionList() {
			//获取仓库（repository）中的流程定义
			ProcessDefinitionQuery query = processEngine.getRepositoryService().createProcessDefinitionQuery();
			//根据版本排序
			query.orderByProcessDefinitionVersion().asc();//升序排列
			List<ProcessDefinition> processDefinitionList = query.list();
			Map<String , ProcessDefinition> processDefinitionMap = new HashMap<String , ProcessDefinition>();
			for (ProcessDefinition processDefinition : processDefinitionList) {
				processDefinitionMap.put(processDefinition.getKey(),processDefinition);
			}
			return new ArrayList<ProcessDefinition>(processDefinitionMap.values());
		}

		
		public void deploy(File resource) {
			//通过仓库（repository）中创建流程定义部署构建器
			DeploymentBuilder deployBuilder = processEngine.getRepositoryService().createDeployment();
			ZipInputStream zipInput = null;
			try {
				zipInput = new ZipInputStream(new FileInputStream(resource));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			deployBuilder.addZipInputStream(zipInput);
			deployBuilder.deploy();
		}

		public InputStream findProcessPicture(String id) {
			//获取仓库（repository）中的流程定义图
			return processEngine.getRepositoryService().getProcessDiagram(id);
		}
		
}
