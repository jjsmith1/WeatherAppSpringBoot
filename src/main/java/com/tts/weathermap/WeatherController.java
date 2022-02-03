package com.tts.weathermap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//annotation critical to make class a controller
//2 types of of annotation : 
// @RestController: return value get displayed a JSON
//returns response from API call
//@Controller:  template that holds a web page (thymeleaf)
// @controller: Returns as a web page   
//has to respond to a mapping

@Controller
public class WeatherController {

	@Autowired
	private WeatherService weatherService;

//only responding to GET REQUEST
//ways to only respond to get:  
//@RequestMapping("value= /", method = {RequestMethod.GET})
//@GetMapping("/")
//wire getIndex variable info from variables used inside
	// getIndex can be displayed on our template web page
	// add parameter to controller method asking SB to figure out
	// a way to make parameter
	// model is a storage variable that we can store variables too
	// accessible by the templating
//public String getIndex(Model model, WeatherService weatherService

	@GetMapping("/")

	public String getIndex(Model model) {

		Request request = new Request();

		request.setZipCode("90210");

		model.addAttribute("request", request);

		return "index";
	}

	@PostMapping(value = "/")
	public String postIndex(Request request, Model model) {
		String zipCode = request.getzipCode();
		Response data = weatherService.getForecast(zipCode);
		model.addAttribute("data", data);
		return "index";

	}

}

//@Autowired

//private WeatherService weatherService;
