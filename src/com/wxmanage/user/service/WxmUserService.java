package com.wxmanage.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.common.base.dao.MyBatisGenericDao;
import com.common.page.Page;
import com.wxmanage.user.dao.WxmUserDao;
import com.wxmanage.user.dto.WxUser;
import com.wxmanage.user.dto.WxUserQueryDto;

@Component
public class WxmUserService extends MyBatisGenericDao<WxUser>  {

	private  Logger logger = Logger.getLogger(WxmUserService.class);

	@Autowired
	private WxmUserDao wxmUserDao;


	public WxUser getWxUser(int id){
		return wxmUserDao.getWxUser(id);
	}


	public WxmUserDao getWxmUserDao() {
		return wxmUserDao;
	}


	public void setWxmUserDao(WxmUserDao wxmUserDao) {
		this.wxmUserDao = wxmUserDao;
	}


	public int updateWxUser(int id) throws Exception {
		int result = wxmUserDao.updateWxUser(id);
		return result;
	}

	/**
	 * 根据条件，查询分页数据
	 * @param page
	 * @param wxUserQueryDto
	 * @return
	 */
	public Page getWxUserByPage(Page page, WxUserQueryDto wxUserQueryDto) {

		return super.listPage("selectPage", page);
	}





}
