package com.baiHoo.activiti.approveInfo.dao.dao;

import java.util.List;

import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.utils.base.BaseDao;

public interface ApproveInfoDao extends BaseDao<ApproveInfoModel> {

	public List<ApproveInfoModel> findListByApplicationId(Integer applicationId);

}
