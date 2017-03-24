package com.baiHoo.activiti.entityView.taskView;

import org.activiti.engine.task.Task;

import com.baiHoo.activiti.application.vo.ApplicationModel;

/**
 * 包装任务信息和申请信息
 * @author 陈柏宏
 *
 */
public class TaskView {
	private Task task;
	private ApplicationModel am;
	
	public TaskView() {
		super();
	}
	public TaskView(Task task, ApplicationModel am) {
		super();
		this.task = task;
		this.am = am;
	}
	
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	public ApplicationModel getAm() {
		return am;
	}
	public void setAm(ApplicationModel am) {
		this.am = am;
	}
}
