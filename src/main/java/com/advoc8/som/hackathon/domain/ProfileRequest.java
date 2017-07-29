package com.advoc8.som.hackathon.domain;

public class ProfileRequest {
	
	private String name;
	private boolean isExist;
	private String picture;
	private String detail;
	
	
	
	
	public ProfileRequest() {
		super();
	}
	
	
	public ProfileRequest(String name, boolean isExist, String picture, String detail) {
		super();
		this.name = name;
		this.isExist = isExist;
		this.picture = picture;
		this.detail = detail;
	}




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isExist() {
		return isExist;
	}
	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
