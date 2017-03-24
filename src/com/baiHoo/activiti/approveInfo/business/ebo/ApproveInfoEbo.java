package com.baiHoo.activiti.approveInfo.business.ebo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.utils.base.BaseEbo;

@Transactional
public interface ApproveInfoEbo extends BaseEbo<ApproveInfoModel>{

	public List<ApproveInfoModel> findListByApplicationId(Integer applicationId);

}
