package com.advoc8.som.hackathon.domain;

public class Response1 {
	
	private String objectId;
	private int rating;
	
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public Response1() {
	}
	
	
	public Response1(String objectId, int rating) {
		super();
		this.objectId = objectId;
		this.rating = rating;
	}
	
	

}
