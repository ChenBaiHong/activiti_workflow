package com.baiHoo.activiti.approveInfo.business.ebi;

import java.io.Serializable;
import java.util.List;

import com.baiHoo.activiti.approveInfo.business.ebo.ApproveInfoEbo;
import com.baiHoo.activiti.approveInfo.dao.dao.ApproveInfoDao;
import com.baiHoo.activiti.approveInfo.vo.ApproveInfoModel;
import com.baiHoo.utils.base.BaseQueryModel;

public class ApproveInfoEbi implements ApproveInfoEbo{
	private ApproveInfoDao approveInfoDao;
	public void setApproveInfoDao(ApproveInfoDao approveInfoDao) {
		this.approveInfoDao = approveInfoDao;
	}

	public void save(ApproveInfoModel am) {
		approveInfoDao.save(am);
	}

	public void update(ApproveInfoModel am) {
		approveInfoDao.update(am);
	}

	public void delete(ApproveInfoModel am) {
		approveInfoDao.delete(am);
	}

	public ApproveInfoModel get(Serializable uuid) {
		return approveInfoDao.get(uuid);
	}

	public List<ApproveInfoModel> getAll() {
		return approveInfoDao.getAll();
	}

	public List<ApproveInfoModel> getAll(BaseQueryModel qm, Integer currentPage,Integer pageDataCount) {
		return approveInfoDao.getAll(qm, currentPage, pageDataCount);
	}

	public Integer getCount(BaseQueryModel qm) {
		return approveInfoDao.getCount(qm);
	}

	public List<ApproveInfoModel> findListByApplicationId(Integer applicationId) {
		
		return approveInfoDao.findListByApplicationId(applicationId) ;
	}

}
