package com.common.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.common.page.Page;
import com.common.page.PageUtil;
import com.common.util.GenericsUtils;


public class MyBatisGenericDao<T> {

	private  Logger logger = Logger.getLogger(MyBatisGenericDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	protected Class<T> entityClass;
	// 分页总条数
	public static final String POSTFIX_PAGECOUNT = "pageCount";

	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	public MyBatisGenericDao() {
		entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	/**
	 * 分页查询公共方法
	 * @param identify SQL XML映射文件执行SQL的ID
	 * @param page
	 * @return
	 */
	public Page listPage(String identify,Page page){
		if(page == null) page = new Page();
		String queryId = getQueryId(entityClass);
		// 获取总条数
		Integer totalCount = (Integer)sqlSessionTemplate.selectOne(queryId+POSTFIX_PAGECOUNT,page.getCondition());
		if(totalCount == null || totalCount.intValue() == 0){
			return new Page();
		}
		// 每业条数
		int everyPage = page.getEveryPage();
		// 当前页
		int currentPage = page.getCurrentPage();
		if(currentPage <=0 ){
			currentPage = 1;
			page.setCurrentPage(1);
		}
		int startIndex = (currentPage - 1)*everyPage;
		int endIndex = currentPage * everyPage;
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("condition", page.getCondition());
		map.put("startIndex", startIndex);
		map.put("endIndex", everyPage);
		List list = sqlSessionTemplate.selectList(queryId+identify,map);
		return PageUtil.createPage(page, totalCount,list);
	}

	/**
	 * 组合mybatis获取xml中的ID
	 * @param
	 */
	private String getQueryId(Class<T> entityClass) {
		if(entityClass == null){
			logger.error("mybatis查询标识id为空！");
			return null;
		}
		String name = entityClass.getName();
		name = name.substring(0,name.lastIndexOf("."));
		StringBuffer result = new StringBuffer();
		result.append(name);
		result.append(".mapper.");
		result.append(entityClass.getSimpleName()).append("Mapper.");
		return result.toString();

	}




}
