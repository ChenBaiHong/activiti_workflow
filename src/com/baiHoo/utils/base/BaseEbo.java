package com.baiHoo.utils.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author 陈柏宏
 *		抽取业务层包含的通用基本的方法
 * @param <T>
 * 
 */
@Transactional
public interface BaseEbo<T> {
	
	public void save(T t);

	public void update(T t);
	
	public void delete(T t);
	
	public List<T> getAll();

	public T get(Serializable uuid);
	
	public List<T> getAll(BaseQueryModel qm, Integer currentPage,Integer pageDataCount);

	public Integer getCount(BaseQueryModel qm);
}
