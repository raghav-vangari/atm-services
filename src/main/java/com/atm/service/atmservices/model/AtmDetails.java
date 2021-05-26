package com.atm.service.atmservices.model;

import java.io.Serializable;
import java.util.List;

public class AtmDetails implements Serializable{

	private static final long serialVersionUID = -6091048902882463085L;
	private Address address;
	private int distance;
	private List<OpeningHoursDetails> openingHours;
	private String functionality;
	private String type;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public List<OpeningHoursDetails> getOpeningHours() {
		return openingHours;
	}
	public void setOpeningHours(List<OpeningHoursDetails> openingHours) {
		this.openingHours = openingHours;
	}
	public String getFunctionality() {
		return functionality;
	}
	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "AtmDetails [address=" + address + ", distance=" + distance + ", openingHours=" + openingHours
				+ ", functionality=" + functionality + ", type=" + type + "]";
	}
	
}
