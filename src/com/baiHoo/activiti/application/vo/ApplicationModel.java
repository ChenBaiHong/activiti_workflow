package com.baiHoo.activiti.application.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.activiti.user.vo.UserModel;

/**
 * 申请实体
 * @author 陈柏宏
 *
 */
public class ApplicationModel implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8652684816002223959L;
	public static final Integer STATUS_APPROVING=111;
	public static final Integer STATUS_UNAPPROVED=121;
	public static final Integer STATUS_APPROVED=131 ;
	
	public static final String STATUS_APPROVING_VIEW = "审批中";
	public static final String STATUS_UNAPPROVED_VIEW = "未通过";
	public static final String STATUS_APPROVED_VIEW = "已通过";
	public static final Map<Integer , String> statusMap = new HashMap<Integer , String>();
	static{
		statusMap.put(STATUS_APPROVING, STATUS_APPROVING_VIEW);
		statusMap.put(STATUS_UNAPPROVED, STATUS_UNAPPROVED_VIEW);
		statusMap.put(STATUS_APPROVED, STATUS_APPROVED_VIEW);
	}
	
	private Integer uuid;
	private String title;						//申请的标题 格式：{模板名称}_{姓名}_{日期}
	private UserModel applicant;				//申请人
	private Date applyDate;						//申请日期
	private Integer status;						//申请状态
	private String docFilePath;					//doc文件路径
	private Set<ApproveInfoModel> aims;			//当前申请对应的多个审批实体
	private TemplateModel tm;					//当前申请使用的模板对象
	
	private String statusView;
	
	
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public UserModel getApplicant() {
		return applicant;
	}
	public void setApplicant(UserModel applicant) {
		this.applicant = applicant;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
		this.statusView = statusMap.get(status);
	}
	public String getDocFilePath() {
		return docFilePath;
	}
	public void setDocFilePath(String docFilePath) {
		this.docFilePath = docFilePath;
	}
	public Set<ApproveInfoModel> getAims() {
		return aims;
	}
	public void setAims(Set<ApproveInfoModel> aims) {
		this.aims = aims;
	}
	public TemplateModel getTm() {
		return tm;
	}
	public void setTm(TemplateModel tm) {
		this.tm = tm;
	}
		
	public String getStatusView() {
		return statusView;
	}
}
