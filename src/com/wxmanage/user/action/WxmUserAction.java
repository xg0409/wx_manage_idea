package com.wxmanage.user.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.common.page.Page;
import com.wxmanage.user.dto.WxUser;
import com.wxmanage.user.dto.WxUserQueryDto;
import com.wxmanage.user.service.WxmUserService;

@Controller
public class WxmUserAction {
	
	@Autowired
	private WxmUserService wxmUserService;
	
	
	@RequestMapping(value={"/getWxUser.do"})
	public String getWxUser(ModelMap model,@ModelAttribute("page")Page page){
		page = wxmUserService.getWxUserByPage(page,new WxUserQueryDto());
		model.addAttribute("page", page);
		return "/wx_info/wxUser";
	}
	
	@RequestMapping("/updateWxUser.do")
	public String updateWxUser(String groupName){
		try {
			int index = wxmUserService.updateWxUser(1);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}


	public WxmUserService getWxmUserService() {
		return wxmUserService;
	}


	public void setWxmUserService(WxmUserService wxmUserService) {
		this.wxmUserService = wxmUserService;
	}
	
	
	
	

}
