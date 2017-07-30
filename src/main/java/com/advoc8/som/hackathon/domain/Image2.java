package com.advoc8.som.hackathon.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image2 {
	
	@JsonProperty("attributes")
	private Attributes attributes;
	
	@JsonProperty("transaction")
    private Transaction transaction;

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

}
