package com.baiHoo.activiti.approveInfo.actionWeb;

import java.util.List;

import com.baiHoo.activiti.approveInfo.business.ebo.ApproveInfoEbo;
import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.activiti.approveInfo.vo.ApproveInfoQueryModel;
import com.baiHoo.utils.base.BaseAction;
@SuppressWarnings("all")
public class ApproveInfoAction extends BaseAction{
	public ApproveInfoModel am = new ApproveInfoModel();
	public ApproveInfoQueryModel aqm = new ApproveInfoQueryModel();

	private ApproveInfoEbo approveInfoEbo;
	public void setApproveInfoEbo(ApproveInfoEbo approveInfoEbo) {
		this.approveInfoEbo = approveInfoEbo;
	}
	public String list(){
		setTotalData(approveInfoEbo.getCount(aqm));
		List<ApproveInfoModel> approveInfoList = approveInfoEbo.getAll(aqm, currentPage, pageDataCount);
		put("approveInfoList", approveInfoList);
		return LIST;
	}
	public String input(){
		if(am.getUuid()!=null){
			am = approveInfoEbo.get(am.getUuid());
		}
		return INPUT;
	}
	public String save(){
		if(am.getUuid() == null){
			approveInfoEbo.save(am);
		}else{
			approveInfoEbo.update(am);
		}
		return TO_LIST;
	}
	public String delete(){
		approveInfoEbo.delete(am);
		return TO_LIST;
	}

}
