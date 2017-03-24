package com.baiHoo.activiti.processController.business.ebo;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.springframework.transaction.annotation.Transactional;

import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.activiti.entityView.taskView.TaskView;
import com.baiHoo.activiti.user.vo.UserModel;

@Transactional
public interface ProcessControllerEbo {
	/**
	 * 获取当前登录人的任务列表
	 * @param login
	 * @return
	 */
	public List<TaskView> getTaskList(UserModel login);
	/**
	 * 审批操作
	 * @param aim					//审批信息实体
	 * @param taskId				//被审批的任务
	 */
	public void approveHandle(ApproveInfoModel aim, String taskId);
	/**
	 * 通过申请实体，获取当前任务
	 * @param uuid
	 * @return
	 */
	public Task findTaskByApplicationUuid(Integer uuid);
	/**
	 * 根据任务获取当前的流程定义
	 * @param task
	 * @return
	 */
	public ProcessDefinition findProcessDefinitionByTask(Task task);
	/**
	 * 根据任务，获取任务在图片中显示的坐标轴和长宽
	 * @param task
	 * @return
	 */
	public Map<String, Object> findCoordingByTask(Task task);
	/**
	 * 根据部署id，图片名字获取部署的图片资源
	 * @param imageName
	 * @param deploymentId
	 * @return
	 */
	public InputStream findDiagramResourcePNG(String imageName,
			String deploymentId);

}
