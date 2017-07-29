
package com.advoc8.som.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {

    @JsonProperty("status")
    private String status;
    @JsonProperty("topLeftX")
    private Integer topLeftX;
    @JsonProperty("topLeftY")
    private Integer topLeftY;
    @JsonProperty("gallery_name")
    private String galleryName;
    @JsonProperty("subject_id")
    private String subjectId;
    @JsonProperty("confidence")
    private Double confidence;
    @JsonProperty("eyeDistance")
    private Integer eyeDistance;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("face_id")
    private Integer faceId;
    @JsonProperty("quality")
    private Double quality;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTopLeftX() {
		return topLeftX;
	}
	public void setTopLeftX(Integer topLeftX) {
		this.topLeftX = topLeftX;
	}
	public Integer getTopLeftY() {
		return topLeftY;
	}
	public void setTopLeftY(Integer topLeftY) {
		this.topLeftY = topLeftY;
	}
	public String getGalleryName() {
		return galleryName;
	}
	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public Double getConfidence() {
		return confidence;
	}
	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}
	public Integer getEyeDistance() {
		return eyeDistance;
	}
	public void setEyeDistance(Integer eyeDistance) {
		this.eyeDistance = eyeDistance;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getFaceId() {
		return faceId;
	}
	public void setFaceId(Integer faceId) {
		this.faceId = faceId;
	}
	public Double getQuality() {
		return quality;
	}
	public void setQuality(Double quality) {
		this.quality = quality;
	}
    
}
