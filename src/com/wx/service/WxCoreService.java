package com.wx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.wx.dto.message.Article;
import com.wx.dto.message.Image;
import com.wx.dto.message.ImageMessage;
import com.wx.dto.message.NewsMessage;
import com.wx.dto.message.TextMessage;
import com.wx.util.MessageUtil;


@Controller
public class WxCoreService {
	static Logger logger = LogManager.getLogger(WxCoreService.class);
	public static String processResponse(HttpServletRequest request){
		// 解析微信服务器发送的请求
		String respXml = null;
		TextMessage textMessage = null;
		try {
			HashMap<String, String> map = MessageUtil.parseXML(request);
			// 开发者openID
			String ToUserName = map.get("ToUserName");
			// 关注者（发消息）openID
			String FromUserName = map.get("FromUserName");
			// 消息类型
			String MsgType = map.get("MsgType");
			String Content = map.get("Content");
			// 响应消息类型
			textMessage = new TextMessage();
			textMessage.setFromUserName(ToUserName);
			textMessage.setToUserName(FromUserName);
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setContent(Content);
			// 判断消息类型
			if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(MsgType)){

				textMessage.setContent("您发送的是文本消息！");
			}else if(MessageUtil.REQ_MESSAGE_TYPE_VIDEO.equals(MsgType)){

				textMessage.setContent("您发送的是视频消息！");
			}else if(MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(MsgType)){

				textMessage.setContent("您发送的是图片消息！");
			}else if(MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(MsgType)){
				// 微信服务器开通语音识别，可接受将语翻译成
				textMessage.setContent("你刚才说：\n\t"+map.get("Recognition"));
			}else if(MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(MsgType)){

				textMessage.setContent("您发送的是地理位置消息！");
			}else if(MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(MsgType)){

				textMessage.setContent("您发送的是链接消息！");
			}else if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(MsgType)){
				MessageUtil.procedure = "";
				// 事件
				String eventType = map.get("Event");
				if(MessageUtil.EVENT_TYPE_SUBSCRIBE.equals(eventType)){
					// 关注事件
					textMessage.setContent("欢迎关注！");
				}else if(MessageUtil.EVENT_TYPE_LOCATION.equals(eventType)){
					// 上报地址位置事件
//					geologyPlaceInfo(map);

				}else if(MessageUtil.EVENT_TYPE_UNSUBSCRIBE.equals(eventType)){
					// 取消关注事件
				}else if(MessageUtil.EVENT_TYPE_MENU_CLICK.equals(eventType)){

				}
			}

		} catch (Exception e) {
			logger.error(e);
		}
		// 判断：对不同的消息请求返回不同的内容
		respXml = MessageUtil.messageToXml(textMessage);
		logger.info("response xml:"+respXml);

		return respXml;
	}





}
