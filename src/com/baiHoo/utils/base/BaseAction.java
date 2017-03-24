package com.baiHoo.utils.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.baiHoo.activiti.user.vo.UserModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 抽取页面关于action对象基本的共同通用的方法
 * 
 * @author 陈柏宏
 *
 */
@Component
public class BaseAction extends ActionSupport{
	
	public BaseAction() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String LIST="list";
	public static final String TO_LIST="toList";
	public static final String INPUT="input";
	
	public Integer currentPage = 1;				//默认分页的页面，特指当前前页，默认当前页是1
	public Integer pageDataCount = 6;			//默认分页页面的数据个数
	public Integer totalPage;					//总共多少页
	public Integer totalData;					//总共多少数据
	public Integer[] pagination; 				//多数据分页页码数组
	
	/**
	 * 根据总共数据的数量算出总共多少页
	 * @param totalData  总共数据的数量
	 */
	public void setTotalData(Integer totalData) {
		this.totalData = totalData;
		this.totalPage = (totalData + pageDataCount -1) / pageDataCount;//在这里除数包含小数点会向下取整
	}
	/**
	 * 
	 * @return pagination 分页页码的数组
	 */
	public Integer[] getPagination() {
		int startPage;
		int endPage;
		if(totalPage==null){//没有数据就返回一个空初始数组容器
			return pagination = new Integer[1];
		}
		if(totalPage<10){
			startPage=1;
			endPage=totalPage;
		}else{
			startPage=currentPage-4;
			endPage=currentPage+5;
			if(startPage<1){
				startPage=1;
				endPage=10;
			}
			if(endPage>totalPage){
				endPage=totalPage;
				startPage=totalPage-9;
			}
		}
		pagination = new Integer[endPage-startPage+1]; //防止出现空指针异常，10-1+1
		int index=0;
		for(;startPage<=endPage;startPage++){
			pagination[index++]=startPage;
		}
		return pagination;
	}
	/**
	 * 
	 * @return 返回当前action的名字
	 * 		DepAction ->dep
	 * 		EmpAction ->emp
	 */
	public String getActionName(){
		//BaseAction ->base
		String actionName = this.getClass().getSimpleName();
		//Base ->base
		String temp = actionName.substring(0, actionName.length()-6);
		return temp.substring(0,1).toLowerCase()+temp.substring(1);
	}
	/**
	 * 页面请求跳转携带数据
	 * @param attributeName  代表对象属性名字
	 * @param obj  数据对象
	 */
	protected void put(String attributeName , Object obj){
		ActionContext.getContext().put(attributeName, obj);//等同于request.setAttribute(attributeName , obj);
	}
	/**
	 * 通过请求跳转，根据对应的属性名获取对应的数据
	 * @param attributeName
	 * @return  返回根据对应属性名得到的数据对象
	 */
	protected Object get(String attributeName){
		return ActionContext.getContext().get(attributeName);//等同于request.getAttribute(attributeName);
	}
	/**
	 * 
	 * @param attributeName 数据对应的属性名
	 * @param obj 对应的数据对象
	 */
	protected void putSession(String attributeName , Object obj){
		ActionContext.getContext().getSession().put(attributeName,obj);
	}
	/**
	 * 
	 * @param attributeName 数据对应的属性名
	 * @return  返回根据对应属性名得到的数据对象
	 */
	protected Object getSession(String attributeName){
		return ActionContext.getContext().getSession().get(attributeName);
	}
	/**
	 * 
	 * @return 登陆用户对象
	 */
	protected UserModel getLogin(){
		return (UserModel) getSession(UserModel.USER_LOGIN_VARIABLE);
	}
	
	protected HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
	protected HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
}
