/**
 * Copyright 2015 Altendis, Groupe Excilys (www.altendis.fr)
 */
package io.gatling.liferay.dto;

public 	class LinkUsecaseRequestDTO {
	long linkId;
	long recordId;
	double weight;
	String name;
	boolean sample;
	
	public LinkUsecaseRequestDTO() {
	}
	
	public LinkUsecaseRequestDTO(Long linkId, Long recordId, Double weight, String name, Boolean isSample) {
		this.linkId = linkId;
		this.recordId = recordId;
		this.weight = weight;
		this.name = name;
		this.sample = isSample;
	}
	
	/*
	 * Getters/Setters
	 */

	public long getLinkId() {
		return linkId;
	}

	public void setLinkId(long linkId) {
		this.linkId = linkId;
	}

	public long getRecordId() {
		return recordId;
	}

	public void setRecordId(long recordId) {
		this.recordId = recordId;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSample() {
		return sample;
	}

	public void setSample(boolean sample) {
		this.sample = sample;
	}
	

	
}