package com.atm.service.atmservices.model;

import java.io.Serializable;

public class GeoLocation implements Serializable {

	private static final long serialVersionUID = 1373504830962736539L;
	private String lat;
	private String lng;
	
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "GeoLocation [lat=" + lat + ", lng=" + lng + "]";
	}
}
