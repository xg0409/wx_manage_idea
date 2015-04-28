package com.wx.ation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wx.service.WxCoreService;
import com.wx.util.SignUtil;


@Controller
public class WxCoreAction {

	Logger logger = Logger.getLogger(WxCoreAction.class);
	@Autowired
	private WxCoreService wxCoreService;

	@RequestMapping(value="/wx_core.do",method={RequestMethod.GET})
	public void tokenVerifyGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");

		if(SignUtil.checkSignature(signature, timestamp, nonce)){
			response.getWriter().print(echostr);
		}

	}

	@RequestMapping(value="/wx_core.do",method={RequestMethod.POST})
	public void wxCorePost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");

		if(SignUtil.checkSignature(signature, timestamp, nonce)){
			logger.error(" HELLO XUGANG ");
			String responseXml = wxCoreService.processResponse(request);
			response.getWriter().print(responseXml);

		}

	}


}
