package com.atm.service.atmservices.model;

import java.io.Serializable;
import java.util.List;

public class OpeningHoursDetails implements Serializable{

	private static final long serialVersionUID = 786799491505738876L;
	private int dayOfWeek;
	private List<Hour> hours;
	
	public int getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public List<Hour> getHours() {
		return hours;
	}
	public void setHours(List<Hour> hours) {
		this.hours = hours;
	}
	
	@Override
	public String toString() {
		return "OpeningHoursDetails [dayOfWeek=" + dayOfWeek + ", hours=" + hours + "]";
	}
}
