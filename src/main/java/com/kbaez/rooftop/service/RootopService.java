package com.kbaez.rooftop.service;

import com.kbaez.rooftop.dto.TokenResponse;

public interface RootopService {
	
	TokenResponse getToken(String mail);
}
