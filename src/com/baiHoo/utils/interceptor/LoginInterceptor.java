package com.baiHoo.utils.interceptor;

import com.baiHoo.activiti.user.vo.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@SuppressWarnings("all")
public class LoginInterceptor  extends AbstractInterceptor{
	
	public String intercept(ActionInvocation invocation) throws Exception {
		//执行除了登录操作之前的所有操作做登录校验
		//获取本次操作的信息
		/*
		System.out.println(invocation.getProxy().getAction());
		System.out.println(invocation.getProxy().getActionName());		
		System.out.println(invocation.getProxy().getMethod());
		*/
		String actionClassName = invocation.getProxy().getAction().getClass().getName();
		String methodName = invocation.getProxy().getMethod();
		String wholeName = actionClassName+"."+methodName;
		//首页登陆跳转
		String operName = invocation.getProxy().getActionName();		//page_login
		if("page_login".equals(operName)){
			return invocation.invoke();
		}
		//登陆访问用户
		if("com.baiHoo.activiti.user.actionWeb.UserAction.ajaxLogin".equals(wholeName)){
			return invocation.invoke();
		}
		UserModel LoginUm = (UserModel) ActionContext.getContext().getSession().get(UserModel.USER_LOGIN_VARIABLE);
		if(LoginUm==null){
			return "noLogin";
		}
		//执行原始操作
		return invocation.invoke();
	}

}
