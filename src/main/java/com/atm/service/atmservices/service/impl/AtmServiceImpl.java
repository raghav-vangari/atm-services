package com.atm.service.atmservices.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.atm.service.atmservices.model.AtmDetails;
import com.atm.service.atmservices.model.AtmList;
import com.atm.service.atmservices.model.Status;
import com.atm.service.atmservices.properties.AppConstants;
import com.atm.service.atmservices.service.AtmService;
import com.google.gson.Gson;

@Service
public class AtmServiceImpl implements AtmService{

	@Value("${atm-endpoint}")
	private String atmEndPoint;	
	
	RestTemplate restTemplate = new RestTemplate();
		
	@Override
	public AtmList getAtmList() {
		List<AtmDetails> atmDetailsList = null;
		Status status = new Status();
		AtmList atmList = new AtmList();
		atmList.setName(AppConstants.ATM_LIST);
		try {
			atmDetailsList = callAtmServices();
			if(atmDetailsList != null && !atmDetailsList.isEmpty()) {
				status.setCode(AppConstants.SUCCESS_200);
				status.setMessage(AppConstants.SUCCESS);
				atmList.setStatus(status);
				atmList.setAtmDetailsList(atmDetailsList);
			} else {
				status.setCode(AppConstants.DATA_NOT_FOUND_500);
				status.setMessage(AppConstants.UNAVILABLE);
				atmList.setStatus(status);
			}	
		}catch (Exception e) {
			status.setCode(AppConstants.ERROR_900);
			status.setMessage(AppConstants.ERROR_PROCESSING_REQUEST);
			atmList.setStatus(status);
		}
		
		return atmList;
	}
	
	@Override
	public AtmList getAtmListByCity(String city) {
		List<AtmDetails> atmDetailsList = null;
		Status status = new Status();
		AtmList atmList = new AtmList();
		atmList.setName(AppConstants.ATM_LIST_BY_CITY);
		try {
			
			atmDetailsList = callAtmServices();
			if(atmDetailsList != null && !atmDetailsList.isEmpty()) {
				atmDetailsList = atmDetailsList.stream().filter(atm -> atm.getAddress().getCity().equals(city)).collect(Collectors.toList());
				
				if(atmDetailsList.isEmpty()) {
					status.setCode(AppConstants.DATA_NOT_FOUND_510);
					status.setMessage(AppConstants.UNAVILABLE_FOR_CITY);
				} else {
					atmList.setAtmDetailsList(atmDetailsList);
					status.setCode(AppConstants.SUCCESS_200);
					status.setMessage(AppConstants.SUCCESS);
				}
				atmList.setStatus(status);
				
			} else {
				status.setCode(AppConstants.DATA_NOT_FOUND_500);
				status.setMessage(AppConstants.UNAVILABLE);
				atmList.setStatus(status);
			}
		}catch (Exception e) {
			status.setCode(AppConstants.ERROR_900);
			status.setMessage(AppConstants.ERROR_PROCESSING_REQUEST);
			atmList.setStatus(status);
		}
		return atmList;
	}
	
	public List<AtmDetails> callAtmServices() {
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(atmEndPoint, String.class);
		String response = null;
		response = responseEntity.getBody();
		response = response.substring(response.indexOf('['));
		final Gson gson = new Gson();
		AtmDetails[] responseList = gson.fromJson(response, AtmDetails[].class);
		return Arrays.asList(responseList);
	}
}
