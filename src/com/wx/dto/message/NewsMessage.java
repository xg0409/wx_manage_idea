package com.wx.dto.message;

import java.util.List;

import com.wx.dto.message.base.MessageBase;

/**
 * 回复图文消息
 * @author Administrator
 *
 */
public class NewsMessage extends MessageBase {

	private int ArticleCount;
	private List<Article> Articles;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Article> getArticles() {
		return Articles;
	}
	public void setArticles(List<Article> articles) {
		Articles = articles;
	}











}
