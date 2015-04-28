package com.wxmanage.user.dto.mapper;

import com.wxmanage.user.dto.WxUser;

public interface WxUserMapper {
	
	public WxUser getWxUser(int id);
	public int updateWxUser(int id);

}
