package com.tts.weathermap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

//used as utility class to do API REQUEST PROCESSING

@Service
public class WeatherService {

	 @Value("${api_key}")
	 private String apiKey;	
		
	//utility func to get forecast for zipcode
 
 	public Response getForecast(String zipCode) {
	    String url = "http://api.openweathermap.org/data/2.5/weather";
	    String fullUrl = url + "?zip=" +
	    zipCode + "&units=imperial&appid=" + apiKey;
	  
	    //to send the web request used in SpringBoot class called RequestTemplate
	    
	    RestTemplate restTemplate = new RestTemplate();
	    Response returnValue;
	    try {
	    	returnValue = restTemplate.getForObject(fullUrl, Response.class);
	   
	    }
	    catch(HttpClientErrorException ex) {
	    	returnValue = new Response();
	    	returnValue.setName("error");
	    	
	    }
	    
	   return returnValue;
	}
}
