package com.wx.dto.message;

import com.wx.dto.message.base.MessageBase;

/**
 * 回复音乐消息
 * @author Administrator
 *
 */
public class MusicMessage extends MessageBase {
	private Music music;

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}


}
