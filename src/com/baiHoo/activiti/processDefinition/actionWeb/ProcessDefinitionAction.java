package com.baiHoo.activiti.processDefinition.actionWeb;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.activiti.engine.repository.ProcessDefinition;

import com.baiHoo.activiti.processDefinition.business.ebo.ProcessDefinitionEbo;
import com.baiHoo.activiti.processDefinition.vo.ProcessDefinitionQueryModel;
import com.baiHoo.utils.base.BaseAction;
@SuppressWarnings("all")
public class ProcessDefinitionAction extends BaseAction{
	
		public ProcessDefinitionQueryModel pdqm = new ProcessDefinitionQueryModel();
	
		private ProcessDefinitionEbo processDefinitionEbo;
		private File resource;//用于接收上传的文件
		public void setProcessDefinitionEbo(ProcessDefinitionEbo processDefinitionEbo) {
			this.processDefinitionEbo = processDefinitionEbo;
		}
		public void setResource(File resource) {
			this.resource = resource;
		}

		public String list(){
			List<ProcessDefinition> pdList = processDefinitionEbo.findNewVsionList();
			put("pdList",pdList);
			return LIST;
		}
		public String input(){
		
			return INPUT;
		}
		public String save(){
			System.out.println(resource);
			processDefinitionEbo.deploy(resource);
			return TO_LIST;
		}
		public String deleteProcessDefinition(){
			System.out.println(pdqm.getKey());
			return TO_LIST;
		}
		
		public String viewProcessPicture(){
			InputStream inputStream = processDefinitionEbo.findProcessPicture(pdqm.getId());
			put("pngStream",inputStream);
			return "viewProcessPicture";
		}
}
