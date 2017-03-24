package com.baiHoo.activiti.application.business.ebi;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

import com.baiHoo.activiti.application.business.ebo.ApplicationEbo;
import com.baiHoo.activiti.application.dao.dao.ApplicationDao;
import com.baiHoo.activiti.application.vo.ApplicationModel;
import com.baiHoo.activiti.application.vo.ApplicationQueryModel;
import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.utils.base.BaseQueryModel;

public class ApplicationEbi implements ApplicationEbo{
	
	private ApplicationDao applicationDao;
	private ProcessEngine processEngine;
	
	public void setApplicationDao(ApplicationDao applicationDao) {
		this.applicationDao = applicationDao;
	}

	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}

	public void save(ApplicationModel am) {
		applicationDao.save(am);
	}

	public void update(ApplicationModel am) {
		applicationDao.update(am);
	}

	public void delete(ApplicationModel am) {
		applicationDao.delete(am);
	}

	public ApplicationModel get(Serializable uuid) {
		return applicationDao.get(uuid);
	}

	public List<ApplicationModel> getAll() {
		return applicationDao.getAll();
	}

	public List<ApplicationModel> getAll(BaseQueryModel qm, Integer currentPage,Integer pageDataCount) {
		return applicationDao.getAll(qm, currentPage, pageDataCount);
	}

	public Integer getCount(BaseQueryModel qm) {
		return applicationDao.getCount(qm);
	}
	
	public void submitApp(UserModel login, TemplateModel temolateModel,
			String docFilePath) {
		//包装一个申请实体
		ApplicationModel application = new ApplicationModel();
		application.setApplicant(login);   //当前申请人
		application.setStatus(ApplicationModel.STATUS_APPROVING);//状态为申请中
		application.setDocFilePath(docFilePath);//申请文档路径
		application.setApplyDate(new Date());// 申请时间
		application.setTm(temolateModel);//申请模板
		//标题头名字 格式{模板名称}_{姓名}_{日期}
		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(application.getApplyDate());
		String title = temolateModel.getName() + "_"
				+ login.getName() + "_" + dateStr;// {模板名称}_{姓名}_{日期}tr;
		application.setTitle(title);// 申请的标题
		
		applicationDao.save(application);
			
		//启动流程实例
		//1. 携带参数 申请实体和申请实体的uuid
		Map<String , Object> variables = new HashMap<String , Object>();
		variables.put("application", application);
		//任务携带申请实体的uuid ， 这样就可以通过当前申请uuid 找到任务
		variables.put("applicationUuid", application.getUuid());
		//2. 通过流程定义的key获取该流程实例
		ProcessInstance processInstance = processEngine.getRuntimeService().
							startProcessInstanceByKey(
											application.getTm().getPdKey(),variables);
		//3. 启动流程实例后，提取申请任务
		TaskQuery query = processEngine.getTaskService().createTaskQuery();
		query.taskAssignee(application.getApplicant().getUserName());//针对任务对应的代理人
		query.processInstanceId(processInstance.getId());//流程实例id使唯一
		Task task = query.singleResult();
		//4. 申请人办理提交自己的申请任务
		processEngine.getTaskService().complete(task.getId());
	}

	@Override
	public List<ApplicationModel> getAllByLoginUser(ApplicationQueryModel aqm,
			UserModel login, Integer currentPage, Integer pageDataCount) {
		return  applicationDao.getAllByLoginUser( aqm, login,  currentPage,  pageDataCount) ;
	}

	@Override
	public Integer getCount(ApplicationQueryModel aqm, UserModel login) {
	
		return applicationDao.getCount(aqm,login);
	}
}











