package com.wxmanage.user.dao;

import com.wxmanage.user.dto.WxUser;
import com.wxmanage.user.dto.mapper.WxUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class WxmUserDao {

    @Autowired
    private WxUserMapper wxUserMapper;

    public WxUser getWxUser(int id) {
        return wxUserMapper.getWxUser(id);
    }


    public WxUserMapper getWxUserMapper() {
        return wxUserMapper;
    }



    public void setWxUserMapper(WxUserMapper wxUserMapper) {

        this.wxUserMapper = wxUserMapper;
    }


    public int updateWxUser(int id) {
        return wxUserMapper.updateWxUser(id);
    }


}
