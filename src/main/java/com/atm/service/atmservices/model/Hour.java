package com.atm.service.atmservices.model;

import java.io.Serializable;

public class Hour implements Serializable{

	private static final long serialVersionUID = -1691339242689076507L;
	private String hourFrom;
	private String hourTo;
	
	public String getHourFrom() {
		return hourFrom;
	}
	public void setHourFrom(String hourFrom) {
		this.hourFrom = hourFrom;
	}
	public String getHourTo() {
		return hourTo;
	}
	public void setHourTo(String hourTo) {
		this.hourTo = hourTo;
	}
	
	@Override
	public String toString() {
		return "Hour [hourFrom=" + hourFrom + ", hourTo=" + hourTo + "]";
	}
	
	
}
