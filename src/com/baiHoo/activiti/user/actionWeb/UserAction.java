package com.baiHoo.activiti.user.actionWeb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.repository.ProcessDefinition;

import com.baiHoo.activiti.processDefinition.business.ebo.ProcessDefinitionEbo;
import com.baiHoo.activiti.template.business.ebo.TemplateEbo;
import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.activiti.user.business.ebo.UserEbo;
import com.baiHoo.activiti.user.vo.UserModel;
import com.baiHoo.activiti.user.vo.UserQueryModel;
import com.baiHoo.utils.base.BaseAction;

@SuppressWarnings("all")
public class UserAction extends BaseAction{
	public UserModel um = new UserModel();
	public UserQueryModel uqm = new UserQueryModel();

	private UserEbo userEbo;
	private String jsonData;
	private ProcessDefinitionEbo processDefinitionEbo;
	private TemplateEbo templateEbo;
	public void setUserEbo(UserEbo userEbo) {
		this.userEbo = userEbo;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setProcessDefinitionEbo(ProcessDefinitionEbo processDefinitionEbo) {
		this.processDefinitionEbo = processDefinitionEbo;
	}
	public void setTemplateEbo(TemplateEbo templateEbo) {
		this.templateEbo = templateEbo;
	}
	/**
	 * 加载默认页面数据
	 * @return
	 */
	public String defaultPage(){
		List<ProcessDefinition> pdList = processDefinitionEbo.findNewVsionList();
		put("pdList",pdList);
		List<TemplateModel> tmList = templateEbo.getAll();
		put("tmList",tmList);
		Integer userCount = userEbo.getCount(uqm);
		put("userCount",userCount);
		return "defaultPage";
	}
	public String showList(){
		return "showList";
	}
	public String list(){
		this.setTotalData(userEbo.getCount(uqm));
		List<UserModel> userList = userEbo.getAll(uqm, currentPage, pageDataCount);
		put("userList",userList);
		return LIST;
	}
	public String input(){
		if(um.getUuid()!=null && um.getUuid()>0){
			um = userEbo.get(um.getUuid());
			return "update";
		}
		return INPUT;
	}
	public String  save(){
		if(um.getUuid() == null){
			userEbo.save(um);
		}else{
			userEbo.update(um);
		}
		return TO_LIST;
	}
	public String  delete(){
		if(um.getUuid() == null){
			userEbo.delete(um);
		}
		return TO_LIST;
	}
	
	public String logout(){
		putSession(UserModel.USER_LOGIN_VARIABLE, null);
		return "noLogin";
	}
	/********************** 开始 AJAX 提交数据  **************************************/
	public String ajaxLogin(){
		um=userEbo.login(um.getUserName(),um.getPassword());
		if(um==null){
			this.jsonData="no";
		}else{
			this.jsonData="yes";
			putSession(UserModel.USER_LOGIN_VARIABLE,um);
		}
		return "ajaxLogin";
	}
	///////////////////////////////////////////////////////
	//
	// 		以下的ajax代码使适应前端的easyUI框架显示数据
	//
	//////////////////////////////////////////////////////
	private  List<UserModel> rows; 		//根据easyUI 前端框架发送相对应的数据
	private Integer total;							//总供多少记录
	public List<UserModel> getRows() {
		return rows;
	}
	public Integer getTotal() {
		return total;
	}
	public String ajaxList(){
		HttpServletRequest request = getRequest();
		String pg=request.getParameter("page");
		String pgSize=request.getParameter("rows");
		if(null==pg||"".equals(pg)){
			currentPage =1;
		}
		if(null==pgSize||"".equals(pgSize)){
			pageDataCount=10;
		}
		currentPage = Integer.parseInt(pg);
		pageDataCount = Integer.parseInt(pgSize);
		setTotalData(userEbo.getCount(uqm));
		rows = userEbo.getAll(uqm, currentPage, pageDataCount);
		total = userEbo.getCount(uqm);
		return "ajaxList";
	}
	
	public String ajaxUpdate(){
		if( userEbo.deleteUser(um)){
			jsonData = "{\"result\":\"true\"}";
		}else{
			jsonData = "{\"msg\":\"数据更新错误！\"}";
		}
		return "ajaxUpdate";
	}
	public String  ajaxDdelete(){
		
		if(userEbo.deleteUser(um)){
			jsonData = "{\"result\":\"true\"}";
		}else{
			jsonData = "{\"msg\":\"数据删除错误！\"}";
		}
		return "ajaxDdelete";
	}
	/********************** 结束AJAX 提交数据  **************************************/
}
