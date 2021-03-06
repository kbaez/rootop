package com.kbaez.rooftop.service;

import com.kbaez.rooftop.dto.BlocksResponse;
import com.kbaez.rooftop.dto.CheckBlockResponse;
import com.kbaez.rooftop.dto.CheckResponse;
import com.kbaez.rooftop.dto.TokenResponse;
import com.kbaez.rooftop.dto.request.BlocksRequest;
import com.kbaez.rooftop.dto.request.CheckRequest;

public interface RooftopService {
	
	TokenResponse getToken(String mail);

	BlocksResponse getBlocks(String token);

	boolean checkBlocks(String token, BlocksRequest request);

	CheckResponse check(String token, BlocksRequest request);
}
