package com.atm.service.atmservices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.atm.service.atmservices.controller.AtmController;
import com.atm.service.atmservices.model.AtmList;
import com.atm.service.atmservices.properties.AppConstants;
import com.atm.service.atmservices.service.impl.AtmServiceImpl;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;

public class GetAtmListTest {

	@Tested
	@Injectable
	AtmServiceImpl atmService;
	
	@Tested
	AtmController controller;
	
	@Mocked
	public RestTemplate restTemplate;
	
	@Test
	public void getAtmListSuccess() {
		
		String response = "[{\"address\":{\"street\":\"Rijperweg\",\"housenumber\":\"50\",\"postalcode\":\"1462 ME\",\"city\":\"Middenbeemster\",\"geoLocation\":{\"lat\":\"52.54895\",\"lng\":\"4.91018\"}},\"distance\":0,\"openingHours\":[{\"dayOfWeek\":2,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":3,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":4,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":5,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":6,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":7,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]},{\"dayOfWeek\":1,\"hours\":[{\"hourFrom\":\"07:00\",\"hourTo\":\"23:00\"}]}],\"functionality\":\"Geldautomaat\",\"type\":\"GELDMAAT\"}]";
		final ResponseEntity<String> responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
		
		new Expectations() {
			{
				restTemplate.getForEntity(anyString, String.class);
				result = responseEntity;
			}
		};
		AtmList atmList = controller.getAtmList();
		assertEquals(AppConstants.SUCCESS_200, atmList.getStatus().getCode());
		assertEquals("Rijperweg", atmList.getAtmDetailsList().get(0).getAddress().getStreet());
	}
	
	@Test
	public void getAtmListEmptyList() {
		String response = "[]";
		final ResponseEntity<String> responseEntity = new ResponseEntity<String>(response, HttpStatus.OK);
		new Expectations() {
			{
				restTemplate.getForEntity(anyString, String.class);
				result = responseEntity;
			}
		};
		AtmList atmList = controller.getAtmList();
		assertEquals(AppConstants.DATA_NOT_FOUND_500, atmList.getStatus().getCode());
		assertEquals(AppConstants.UNAVILABLE, atmList.getStatus().getMessage());
	}
	
	@Test
	public void getAtmListException() {
		new Expectations() {
			{
				restTemplate.getForEntity(anyString, String.class);
				result = new Exception();
			}
		};
		AtmList atmList = controller.getAtmList();
		assertEquals(AppConstants.ERROR_900, atmList.getStatus().getCode());
		assertEquals(AppConstants.ERROR_PROCESSING_REQUEST, atmList.getStatus().getMessage());
		
	}
}
