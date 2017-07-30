package com.advoc8.som.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Gender {
	
	@JsonProperty("type")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
