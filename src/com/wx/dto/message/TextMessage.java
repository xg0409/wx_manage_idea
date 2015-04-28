package com.wx.dto.message;

import com.wx.dto.message.base.MessageBase;

/**
 * 回复图片消息
 * @author Administrator
 *
 */
public class TextMessage extends MessageBase {

	// 消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[FromUserName:"+super.getFromUserName()+"]"+
				"[ToUserName:"+super.getToUserName()+"]"+
				"[MsgType:"+super.getMsgType()+"]"+
				"[Content:"+getContent()+"]";
	}









}
