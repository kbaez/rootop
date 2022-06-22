package com.kbaez.rooftop.service.impl;

import org.springframework.web.client.RestTemplate;

import com.kbaez.rooftop.dto.TokenResponse;
import com.kbaez.rooftop.service.RootopService;

public class RootopServiceImpl implements RootopService{
	
	private final String URI = "https://rooftop-career-switch.herokuapp.com/token?email=";

	@Override
	public TokenResponse getToken(String mail) {
		URI = URI + mail;
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(URI, String.class);
	    
	    return System.out.println(result);
	}

}
