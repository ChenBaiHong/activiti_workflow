package com.baiHoo.activiti.template.actionWeb;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.activiti.engine.repository.ProcessDefinition;

import com.baiHoo.activiti.processDefinition.business.ebo.ProcessDefinitionEbo;
import com.baiHoo.activiti.template.business.ebo.TemplateEbo;
import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.activiti.template.vo.TemplateQueryModel;
import com.baiHoo.utils.base.BaseAction;
import com.baiHoo.utils.downloadUtils.DownloadUtils;
import com.baiHoo.utils.uploadUtils.UploadUtils;
@SuppressWarnings("all")
public class TemplateAction extends BaseAction{
	public TemplateModel tm = new TemplateModel();
	public TemplateQueryModel tqm = new TemplateQueryModel();

	private TemplateEbo templateEbo;
	private ProcessDefinitionEbo processDefinitionEbo ;
	private File resource;//用于接收上传的文件
	public void setTemplateEbo(TemplateEbo templateEbo) {
		this.templateEbo = templateEbo;
	}

	public void setProcessDefinitionEbo(ProcessDefinitionEbo processDefinitionEbo) {
		this.processDefinitionEbo = processDefinitionEbo;
	}
	public void setResource(File resource) {
		this.resource = resource;
	}

	public String list(){
		setTotalData(templateEbo.getCount(tqm));
		List<TemplateModel> templateList = templateEbo.getAll(tqm, currentPage, pageDataCount);
		put("templateList", templateList);
		return LIST;
	}
	public String input(){
		List<ProcessDefinition> pdList = processDefinitionEbo.findNewVsionList();
		put("pdList" , pdList);
		if(tm.getUuid()!=null){
			tm = templateEbo.get(tm.getUuid());
		}
		return INPUT;
	}
	public String save(){
		if(tm.getUuid() == null){
			tm.setDocFilePath(UploadUtils.copyFile(resource));
			templateEbo.save(tm);
		}else{
			if(resource!=null){
				tm.setDocFilePath(UploadUtils.copyFile(resource));
			}
			templateEbo.update(tm);
		}
		return TO_LIST;
	}
	public String delete(){
		templateEbo.delete(tm);
		return TO_LIST;
	}
	public String downloadDoc(){
		if(tm.getUuid() != null){
			tm = templateEbo.get(tm.getUuid());
			InputStream docStream = templateEbo.downloadDoc(tm);
			put("docStream",docStream);
			String myFilename = tm.getName() + ".doc";
			String agent = getRequest().getHeader("user-agent");
			myFilename = DownloadUtils.encodeDownloadFilename(myFilename, agent);
			put("myFilename", myFilename);
		}
		return "downloadDoc";
	}
}
