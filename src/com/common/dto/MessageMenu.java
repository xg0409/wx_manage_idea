package com.common.dto;

import java.util.Date;

public class MessageMenu {
	
	private String image;
	private String fromName;
	private String fromDate;
	private String contant;
	
	
	
	public MessageMenu(String image, String fromName, String fromDate,
			String contant) {
		super();
		this.image = image;
		this.fromName = fromName;
		this.fromDate = fromDate;
		this.contant = contant;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	
	public String getContant() {
		return contant;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	@Override
	public String toString() {
		return "MessageMenu [image=" + image + ", fromName=" + fromName
				+ ", fromDate=" + fromDate + ", contant=" + contant + "]";
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	

}
