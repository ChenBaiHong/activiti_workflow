package com.baiHoo.activiti.template.business.ebi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import com.baiHoo.activiti.template.business.ebo.TemplateEbo;
import com.baiHoo.activiti.template.dao.dao.TemplateDao;
import com.baiHoo.activiti.template.vo.TemplateModel;
import com.baiHoo.utils.base.BaseQueryModel;
import com.baiHoo.utils.uploadUtils.UploadUtils;

public class TemplateEbi implements TemplateEbo{
	private TemplateDao templateDao;
	public void setTemplateDao(TemplateDao templateDao) {
		this.templateDao = templateDao;
	}

	public void save(TemplateModel tm) {
		templateDao.save(tm);
	}

	public void update(TemplateModel tm) {
		TemplateModel temp = templateDao.get(tm.getUuid());
		if(tm.getDocFilePath()!=null){
			UploadUtils.deleteUpdateFile(temp.getDocFilePath());
			temp.setDocFilePath(tm.getDocFilePath());
		}
		temp.setName(tm.getName());
		temp.setPdKey(tm.getPdKey());
	}

	public void delete(TemplateModel tm) {
		templateDao.delete(tm);
	}

	public TemplateModel get(Serializable uuid) {
		return templateDao.get(uuid);
	}

	public List<TemplateModel> getAll() {
		return templateDao.getAll();
	}

	public List<TemplateModel> getAll(BaseQueryModel qm, Integer currentPage,Integer pageDataCount) {
		return templateDao.getAll(qm, currentPage, pageDataCount);
	}

	public Integer getCount(BaseQueryModel qm) {
		return templateDao.getCount(qm);
	}

	@Override
	public InputStream downloadDoc(TemplateModel tm) {
		if (tm.getDocFilePath()==null) return null;
		try {
			return new FileInputStream(new File(tm.getDocFilePath()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public TemplateModel findTemplateByUuid(Integer templateUuid) {
		
		return templateDao.findTemplateByUuid(templateUuid);
	}
}
