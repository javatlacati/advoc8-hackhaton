package com.advoc8.som.hackathon.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "beggar")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Beggar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private UUID id;
	
	@Column(name="app_id")
	private String appId;
	
	@Column(name="object_id")
	private String objectId;
	
	@Column(name="detail")
	private String detail;
	
	@Column(name="category")
	private String category;	
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	private int age;
	
	@Column(name="main")
	private boolean main;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMain() {
		return main;
	}

	public void setMain(boolean main) {
		this.main = main;
	}

	public Beggar() {
		
	}

	public Beggar(String appId, String objectId, String detail, String category, int rating, String gender,
			int age, boolean main) {
		super();
		this.appId = appId;
		this.objectId = objectId;
		this.detail = detail;
		this.category = category;
		this.rating = rating;
		this.gender = gender;
		this.age = age;
		this.main = main;
	}
	
}
