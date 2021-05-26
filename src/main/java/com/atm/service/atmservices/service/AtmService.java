package com.atm.service.atmservices.service;

import com.atm.service.atmservices.model.AtmList;

public interface AtmService {

	public AtmList getAtmList();
	public AtmList getAtmListByCity(String city);
}
