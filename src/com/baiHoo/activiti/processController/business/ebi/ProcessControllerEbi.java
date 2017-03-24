package com.baiHoo.activiti.processController.business.ebi;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;

import com.baiHoo.activiti.application.vo.ApplicationModel;
import com.baiHoo.activiti.approveInfo.dao.dao.ApproveInfoDao;
import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.activiti.entityView.taskView.TaskView;
import com.baiHoo.activiti.processController.business.ebo.ProcessControllerEbo;
import com.baiHoo.activiti.user.vo.UserModel;

public class ProcessControllerEbi implements ProcessControllerEbo{
	private ProcessEngine processEngine;
	private ApproveInfoDao approveInfoDao;
	public void setProcessEngine(ProcessEngine processEngine) {
		this.processEngine = processEngine;
	}
	public void setApproveInfoDao(ApproveInfoDao approveInfoDao) {
		this.approveInfoDao = approveInfoDao;
	}

	public List<TaskView> getTaskList(UserModel login) {
		TaskQuery query = processEngine.getTaskService().createTaskQuery();
		//获取当前办理人的办理任务
		query.taskAssignee(login.getName());
		query.orderByTaskCreateTime().desc();//降序排序
		List<Task> taskList = query.list();
		
		List<TaskView> taskViewList = new ArrayList<TaskView>();
		for (Task task : taskList) {
			//获取给当前登录人制造任务的任务人（application.applicant.userName）
			ApplicationModel am = (ApplicationModel) processEngine.getTaskService().getVariable(task.getId(), "application");
			TaskView taskView = new TaskView(task,am);
			taskViewList.add(taskView);
		}
		return taskViewList;
	}

	@Override
	public void approveHandle(ApproveInfoModel aim, String taskId) {
		
		TaskQuery tQuery =processEngine.getTaskService().createTaskQuery();
		tQuery.taskId(taskId);
			Task task = tQuery.singleResult();
		// 通过任务获得流程实例id
		String processInstanceId = task.getProcessInstanceId();
		// 1、保存审批实体
		approveInfoDao.save(aim);//持久对象
		// 2、办理当前的任务
		processEngine.getTaskService().complete(taskId);
		
		// 查询当前的流程实例是否存在
		ProcessInstanceQuery pQuery  =processEngine.getRuntimeService().createProcessInstanceQuery();
		pQuery.processInstanceId(processInstanceId);
		ProcessInstance processInstance =pQuery.singleResult();
		
		ApplicationModel applicationModel = aim.getAm();//持久对象
		
		if(aim.getApproval()==ApproveInfoModel.APPROVED){//如过结果为通过
			if (processInstance == null) {// 如果当前办理人为最后一个节点，将申请的状态修改为“已通过”
				applicationModel.setStatus(ApplicationModel.STATUS_APPROVED);
			}
		} else {// 如果审批的结果为"不通过"
			// 将申请的状态修改为“不通过”
			applicationModel.setStatus(ApplicationModel.STATUS_UNAPPROVED);
			// 如果当前办理人不是最后一个节点，手动结束流程
			if (processInstance != null) {
				processEngine.getRuntimeService().deleteProcessInstance(
						processInstanceId, ApplicationModel.STATUS_UNAPPROVED_VIEW);
			}
		}
	}
	public Task findTaskByApplicationUuid(Integer uuid) {
		/**
		 * 根据申请id（流程变量）查询任务
		 */
		TaskQuery query = processEngine.getTaskService().createTaskQuery();
		// 根据设置的流程变量进行过滤
		query.processVariableValueEquals("applicationUuid", uuid);
		return query.singleResult();
	}
	@Override
	public ProcessDefinition findProcessDefinitionByTask(Task task) {
		//任务中获取当前流程定义的id
		String processDefinitionId = task.getProcessDefinitionId();
		ProcessDefinitionQuery query = processEngine.getRepositoryService().createProcessDefinitionQuery();
		query.processDefinitionId(processDefinitionId);
		return query.singleResult();
	}
	@Override
	public Map<String, Object> findCoordingByTask(Task task) {
		// 1 . 获得流程定义id
		String processDefinitionId = task.getProcessDefinitionId();
		
		// 2 . 获得流程实例id
		String processInstanceId = task.getProcessInstanceId();
		
		// 3 . 返回的流程定义对象中包含坐标信息 ， 通过流程定义id
		ProcessDefinitionEntity processDefinitionEntity =   (ProcessDefinitionEntity) 
								processEngine.getRepositoryService().getProcessDefinition(processDefinitionId);
		
		// 4 . 返回的当前流程实例对象，流程实例对象中包含当前任务的活动轨迹(activityId)
		ProcessInstanceQuery query = processEngine.getRuntimeService().createProcessInstanceQuery();
		query.processInstanceId(processInstanceId);//根据流程实例id过滤
		ProcessInstance processInstance = query.singleResult();
			// 4.1 根据流程实例对象获得当前的活动节点
			String activityId = processInstance.getActivityId();//流程实例对象中包含当前任务的活动轨迹(activityId)
		
		// 5. 根据活动节点，获取坐标轴，及长宽
		ActivityImpl  activityImpl = processDefinitionEntity.findActivity(activityId);
		Integer x = activityImpl.getX();
		Integer y = activityImpl.getX();
		Integer height = activityImpl.getHeight();
		Integer width = activityImpl.getHeight();
		
		//放入坐标长宽信息到map中去
		Map<String ,Object> map = new HashMap<String , Object>();
		map.put("x", x);
		map.put("y", y);
		map.put("height", height);
		map.put("width", width);
		return map;
	}
	@Override
	public InputStream findDiagramResourcePNG(String imageName,
			String deploymentId) {
		
		return processEngine.getRepositoryService().getResourceAsStream(deploymentId, imageName);
	}
}
