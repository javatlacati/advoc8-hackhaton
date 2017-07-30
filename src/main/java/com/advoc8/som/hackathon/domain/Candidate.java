
package com.advoc8.som.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Candidate {

    @JsonProperty("subject_id")
    private String subjectId;
    @JsonProperty("face_id")
    private String faceId;
    @JsonProperty("confidence")
    private Double confidence;
    @JsonProperty("enrollment_timestamp")
    private String enrollmentTimestamp;
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getFaceId() {
		return faceId;
	}
	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}
	public Double getConfidence() {
		return confidence;
	}
	public void setConfidence(Double confidence) {
		this.confidence = confidence;
	}
	public String getEnrollmentTimestamp() {
		return enrollmentTimestamp;
	}
	public void setEnrollmentTimestamp(String enrollmentTimestamp) {
		this.enrollmentTimestamp = enrollmentTimestamp;
	}
    
    

}
