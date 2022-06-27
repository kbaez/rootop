package com.kbaez.rooftop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kbaez.rooftop.dto.BlocksResponse;
import com.kbaez.rooftop.dto.CheckBlockResponse;
import com.kbaez.rooftop.dto.CheckResponse;
import com.kbaez.rooftop.dto.TokenResponse;
import com.kbaez.rooftop.dto.request.BlocksRequest;
import com.kbaez.rooftop.service.RooftopService;

@RestController
@Validated
public class RootopController {
	
	@Autowired
	RooftopService rootopService;
	
	@GetMapping("/token/{mail}")
	public ResponseEntity<TokenResponse> getToken(@PathVariable(value = "mail") String mail) {
		TokenResponse response = rootopService.getToken(mail);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/blocks/{token}")
	public ResponseEntity<BlocksResponse> getBlocks(@PathVariable(value = "token") String token) {
		BlocksResponse response = rootopService.getBlocks(token);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/check/{token}")
	public ResponseEntity<CheckResponse> checkBlocks(@PathVariable(value = "token") String token, @RequestBody BlocksRequest request) {
		CheckResponse response = rootopService.check(token, request);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
