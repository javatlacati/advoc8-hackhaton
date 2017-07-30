package com.advoc8.som.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attributes {
	
	@JsonProperty("age")
	private int age;
	
	@JsonProperty("gender")
	private Gender gender;


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
}
