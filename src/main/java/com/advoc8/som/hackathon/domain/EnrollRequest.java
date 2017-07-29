package com.advoc8.som.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnrollRequest {
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("subject_id")
	private String subjectId;
	
	@JsonProperty("gallery_name")
	private String galleryName;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjecId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}
	
	public EnrollRequest() {
	}
	
	public EnrollRequest(String image, String subjectId, String galleryName) {
		super();
		this.image = image;
		this.subjectId = subjectId;
		this.galleryName = galleryName;
	}
}
