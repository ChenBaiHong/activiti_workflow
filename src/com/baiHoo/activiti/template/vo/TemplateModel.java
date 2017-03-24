package com.baiHoo.activiti.template.vo;

import java.io.Serializable;

/**
 * 表单模板实体
 * @author 陈柏宏
 *
 */
public class TemplateModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1103381346908041860L;
	
	private Integer uuid;
	private String name;						
	private String pdKey;							//processDefinition ,流程定义键
	private String docFilePath;				//doc文档保存路径
	
	public Integer getUuid() {
		return uuid;
	}
	public void setUuid(Integer uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPdKey() {
		return pdKey;
	}
	public void setPdKey(String pdKey) {
		this.pdKey = pdKey;
	}
	public String getDocFilePath() {
		return docFilePath;
	}
	public void setDocFilePath(String docFilePath) {
		this.docFilePath = docFilePath;
	}
	
}
