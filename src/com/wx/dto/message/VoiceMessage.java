package com.wx.dto.message;

import com.wx.dto.message.base.MessageBase;

/**
 * 回复语音消息
 * @author Administrator
 *
 */
public class VoiceMessage extends MessageBase {
	private Voice voice;

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}




}
