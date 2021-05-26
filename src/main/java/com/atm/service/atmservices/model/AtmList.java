package com.atm.service.atmservices.model;

import java.io.Serializable;
import java.util.List;

public class AtmList extends ServiceCommonOutput implements Serializable{

	private static final long serialVersionUID = 6619814201773344510L;
	private List<AtmDetails> atmDetailsList;
	
	public List<AtmDetails> getAtmDetailsList() {
		return atmDetailsList;
	}
	public void setAtmDetailsList(List<AtmDetails> atmDetailsList) {
		this.atmDetailsList = atmDetailsList;
	}
	@Override
	public String toString() {
		return "AtmList [atmDetailsList=" + atmDetailsList + "]";
	}
	
}
