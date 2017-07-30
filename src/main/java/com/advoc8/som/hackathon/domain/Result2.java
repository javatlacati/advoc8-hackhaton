package com.advoc8.som.hackathon.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result2 {

	@JsonProperty("images")
	private List<Image2> images;

	public List<Image2> getImages() {
		return images;
	}

	public void setImages(List<Image2> images) {
		this.images = images;
	}

}
