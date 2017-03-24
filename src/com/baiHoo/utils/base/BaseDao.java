package com.baiHoo.utils.base;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author 陈柏宏
 *		抽取页面关于对象数据层包含的通用基本的方法
 */

public interface BaseDao<T> {
	
	public void save(T t);

	public void update(T t);

	public void delete(T t);
	
	public List<T> getAll();

	public T get(Serializable uuid);

	public List<T> getAll(BaseQueryModel qm, Integer currentPage,Integer pageDataCount);

	public Integer getCount(BaseQueryModel qm);
}
