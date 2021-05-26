package com.atm.service.atmservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.atm.service.atmservices.model.AtmList;
import com.atm.service.atmservices.model.Status;
import com.atm.service.atmservices.properties.AppConstants;
import com.atm.service.atmservices.service.AtmService;

@RestController
public class AtmController {

	@Autowired
	AtmService atmService;
	
	@GetMapping("/atms")
	public AtmList getAtmList() {
		return atmService.getAtmList();
	}
	
	@GetMapping("/atm/{city}")
	public AtmList getAtmListByCity(@PathVariable("city") String city) {
		if(city == null || city.isEmpty() || city.trim().isEmpty()) {
			Status status = new Status();
			AtmList atmList = new AtmList();
			status.setCode(AppConstants.MISSING_300);
			status.setMessage(AppConstants.SEND_CITY_NAME);
			atmList.setStatus(status);
			return atmList;
		} else {
			return atmService.getAtmListByCity(city);
		}
	}
}
