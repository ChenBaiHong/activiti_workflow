package com.baiHoo.activiti.approveInfo.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.baiHoo.activiti.application.vo.ApplicationModel;
import com.baiHoo.activiti.user.vo.UserModel;

/**
 * 审批实体
 * @author 陈柏宏
 *
 */
public class ApproveInfoModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8599730790216209843L;
	
	
	public static final Integer UNAPPROVED=111;
	public static final Integer APPROVED=121;
	public static final String UNAPPROVED_VIEW = "未通过";
	public static final String APPROVED_VIEW = "已通过";
	public static final Map<Integer , String> isApprovalMap = new HashMap<Integer , String>();
	
	static{
		isApprovalMap.put(UNAPPROVED, UNAPPROVED_VIEW);
		isApprovalMap.put(APPROVED, APPROVED_VIEW);
	}
	
	private Integer uuid;
	private UserModel approver;				//审批人
	private Date approveDate;				//审批时间
	private Integer approval;				//是否通过
	private String comment;					//审批意见
	private ApplicationModel am;			//当前审批对应的申请实体
	
	private String approvalView;
	
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public UserModel getApprover() {
		return approver;
	}
	public void setApprover(UserModel approver) {
		this.approver = approver;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public Integer getApproval() {
		return approval;
	}
	public void setApproval(Integer approval) {
		this.approval = approval;
		this.approvalView = isApprovalMap.get(approval);
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public ApplicationModel getAm() {
		return am;
	}
	public void setAm(ApplicationModel am) {
		this.am = am;
	}
	
	public String getApprovalView() {
		return approvalView;
	}
	
}
