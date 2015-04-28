package com.wx.dto.message;

import com.wx.dto.message.base.MessageBase;

/**
 * 回复视频消息
 * @author Administrator
 *
 */
public class VideoMessage extends MessageBase {
	private Video video;

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;

	}






}
