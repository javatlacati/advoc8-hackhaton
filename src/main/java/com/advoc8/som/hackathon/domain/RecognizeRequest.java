package com.advoc8.som.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecognizeRequest {
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("gallery_name")
	private String galleryName;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}
	
	public RecognizeRequest() {
	}

	public RecognizeRequest(String image, String galleryName) {
		super();
		this.image = image;
		this.galleryName = galleryName;
	}
	
	


}
