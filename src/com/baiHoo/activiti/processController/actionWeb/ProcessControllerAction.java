package com.baiHoo.activiti.processController.actionWeb;

import java.util.Date;
import java.util.List;

import com.baiHoo.activiti.application.business.ebo.ApplicationEbo;
import com.baiHoo.activiti.application.vo.ApplicationModel;
import com.baiHoo.activiti.approveInfo.business.ebo.ApproveInfoEbo;
import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.activiti.entityView.taskView.TaskView;
import com.baiHoo.activiti.processController.business.ebo.ProcessControllerEbo;
import com.baiHoo.activiti.template.business.ebo.TemplateEbo;
import com.baiHoo.utils.base.BaseAction;
@SuppressWarnings("all")
public class ProcessControllerAction extends BaseAction{
	
	private ProcessControllerEbo processControllerEbo;
	private TemplateEbo templateEbo;
	private ApplicationEbo applicationEbo;
	private Integer applicationId;
	private String taskId;
	private Boolean approval;
	private String opinionContent;
	private ApproveInfoEbo approveInfoEbo;
	
	public void setProcessControllerEbo(ProcessControllerEbo processControllerEbo) {
		this.processControllerEbo = processControllerEbo;
	}
	public void setTemplateEbo(TemplateEbo templateEbo) {
		this.templateEbo = templateEbo;
	}
	public Integer getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public void setApproval(Boolean approval) {
		this.approval = approval;
	}
	public void setOpinionContent(String opinionContent) {
		this.opinionContent = opinionContent;
	}
	public void setApplicationEbo(ApplicationEbo applicationEbo) {
		this.applicationEbo = applicationEbo;
	}
	public void setApproveInfoEbo(ApproveInfoEbo approveInfoEbo) {
		this.approveInfoEbo = approveInfoEbo;
	}
	public String list(){
		
		return LIST;
	}
	public String input(){
	
		return INPUT;
	}
	public String save(){
		
		return TO_LIST;
	}
	public String delete(){
		
		return TO_LIST;
	}
	/**
	 * 我的任务列表
	 * @return
	 */
	public String myTaskList(){
		List<TaskView> taskList = processControllerEbo.getTaskList(getLogin());
		put("taskList",taskList);
		return "myTaskList";
	}
	/**
	 * 执行任务人
	 * 审批处理UI界面
	 * @return
	 */
	public String approveUI(){
		System.out.println(applicationId+","+taskId);
		return "approveUI";
	}
	/**
	 * 任务的审批流转记录信息UI界面
	 * 查看流转记录（根据申请id查询多个审批对象）
	 * @return
	 */
	public String approveInfoUI(){
		List<ApproveInfoModel>list = approveInfoEbo.findListByApplicationId(applicationId);
		put("list" , list);
		return "approveInfoUI";
	}
	/**
	 * 审批操作
	 * @return
	 */
	public String approveHandle(){
		ApplicationModel application = applicationEbo.get(applicationId);
		//1、包装一个审批实体并保存
		ApproveInfoModel aim = new ApproveInfoModel();
		aim.setAm(application);						//审批对应的申请实体
		aim.setApproval(approval==true?ApproveInfoModel.APPROVED:ApproveInfoModel.UNAPPROVED);//是否通过
		aim.setApproveDate(new Date());		//审批时间
		aim.setApprover(getLogin());				//审批人
		aim.setComment(opinionContent);		//审批意见
		
		processControllerEbo.approveHandle(aim , taskId);
		return "toMyTaskList";
	}
}
