package com.kbaez.rooftop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.kbaez.rooftop.dto.TokenResponse;
import com.kbaez.rooftop.service.RootopService;

@RestController
@Validated
public class RootopController {
	
	@Autowired
	RootopService rootopService;
	
	@GetMapping("/token/{mail}")
	public ResponseEntity<TokenResponse> getToken(@PathVariable(value = "mail") String mail) {

		TokenResponse response = rootopService.getToken(mail);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
