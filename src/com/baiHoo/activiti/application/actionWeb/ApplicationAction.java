package com.baiHoo.activiti.application.actionWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;

import com.baiHoo.activiti.application.business.ebo.ApplicationEbo;
import com.baiHoo.activiti.application.vo.ApplicationModel;
import com.baiHoo.activiti.application.vo.ApplicationQueryModel;
import com.baiHoo.activiti.processController.business.ebo.ProcessControllerEbo;
import com.baiHoo.activiti.template.business.ebo.TemplateEbo;
import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.utils.base.BaseAction;
import com.baiHoo.utils.downloadUtils.DownloadUtils;
import com.baiHoo.utils.uploadUtils.UploadUtils;
@SuppressWarnings("all")
public class ApplicationAction extends BaseAction{
	public ApplicationModel am = new ApplicationModel();
	public ApplicationQueryModel aqm = new ApplicationQueryModel();

	private TemplateEbo templateEbo;
	private ApplicationEbo applicationEbo;
	private ProcessControllerEbo processControllerEbo;
	private Integer templateUuid;
	private File resource;
	
	public Integer getTemplateUuid() {
		return templateUuid;
	}
	public void setTemplateUuid(Integer templateUuid) {
		this.templateUuid = templateUuid;
	}
	public void setTemplateEbo(TemplateEbo templateEbo) {
		this.templateEbo = templateEbo;
	}
	public void setApplicationEbo(ApplicationEbo applicationEbo) {
		this.applicationEbo = applicationEbo;
	}
	public void setProcessControllerEbo(ProcessControllerEbo processControllerEbo) {
		this.processControllerEbo = processControllerEbo;
	}
	public void setResource(File resource) {
		this.resource = resource;
	}
	public String list(){
		setTotalData(applicationEbo.getCount(aqm));
		List<ApplicationModel> applicationList = applicationEbo.getAll(aqm, currentPage, pageDataCount);
		put("applicationList", applicationList);
		return LIST;
	}
	public String input(){
		if(am.getUuid()!=null){
			am = applicationEbo.get(am.getUuid());
		}
		return INPUT;
	}
	public String save(){
		if(am.getUuid() == null){
			applicationEbo.save(am);
		}else{
			applicationEbo.update(am);
		}
		return TO_LIST;
	}
	public String delete(){
		applicationEbo.delete(am);
		return TO_LIST;
	}
	/**
	 * 进入起草申请模板页
	 * @return
	 */
	public String appList(){
		List<TemplateModel> templateList = templateEbo.getAll();
		put("templateList", templateList);
		return "appList";
	}
	/**
	 *前往申请模板页
	 * @return
	 */
	public String appUI(){
		return "appUI";
	}
	/**
	 * 提交申请
	 * @return
	 */
	public String submitApp(){
		if(templateUuid!=null && templateUuid >0 && resource!=null){
			//获取模板实体
			TemplateModel template = templateEbo.findTemplateByUuid(templateUuid);
			//提交的申请文档
			String docFilePath = UploadUtils.copyFile(resource);
			//提交申请
			applicationEbo.submitApp(getLogin(),template ,docFilePath );
		}
		return "toAppList";
	}
	/**
	 * 下载申请人的申请文档
	 * @return
	 * @throws FileNotFoundException 
	 */
	public String downloadAppDoc() throws FileNotFoundException{
		if(am.getUuid()!=null && am.getUuid()>0){
			ApplicationModel model = applicationEbo.get(am.getUuid());
			InputStream docStream = new FileInputStream(new File(model.getDocFilePath()));
			put("docStream" , docStream);
			String myFileName = "[ "+model.getApplicant().getUserName()+" ]"+model.getTm().getName()+"文档.docx";
			myFileName = DownloadUtils.encodeDownloadFilename(myFileName,getRequest().getHeader("user-agent"));
			put("myFilename",myFileName);
		}
		return "downloadAppDoc";
	}
	/**
	 * 我的申请列表信息
	 * @return
	 */
	public String myApplicationList(){
		setTotalData(applicationEbo.getCount(aqm ,getLogin()));
		List<ApplicationModel> applicationList = applicationEbo.getAllByLoginUser(aqm, getLogin(),currentPage, pageDataCount);
		put("applicationList", applicationList);
		return "myApplicationList";
	}
	/**
	 * 显示流程的进程图片
	 * 绘制出流程图任务的坐标位置即长宽高的数据
	 * @return
	 */
	public String showProcessPNG(){
		// 通过applicationId ,申请人的id找到当前任务
		// 准备数据：deploymentId imageName acs.y acs.x acs.height acs.width
		// 1. 根据流程变量查询当前任务
		Task task = processControllerEbo.findTaskByApplicationUuid(am.getUuid());
		put("assignee",task.getAssignee());
		put("name",task.getName());
		// 2. 根据当前的任务查询对应的流程定义对象
		ProcessDefinition pd = processControllerEbo.findProcessDefinitionByTask(task);
		
		//3. 为显示图片做预定义准备，
			//3.1. 通过流程定义获取部署id,和图片资源的名字
			put("imageName",pd.getDiagramResourceName());
			put("deploymentId",pd.getDeploymentId());
			
			//3.2. 根据任务，获取任务在图片中显示的坐标轴和长宽
			Map<String , Object> map = processControllerEbo.findCoordingByTask(task);
			put("acs",map);
			
			
		return "showProcessPNG";
	}
	private String imageName;
	private String deploymentId;
	/**
	 * 显示流程的进程图片
	 * @return
	 */
	public String viewProcessPNG(){
		InputStream inputStream = processControllerEbo.findDiagramResourcePNG(imageName, deploymentId);
		put("pngStream",inputStream);
		return "viewProcessPNG";
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	
}
