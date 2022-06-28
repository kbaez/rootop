package com.kbaez.rooftop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kbaez.rooftop.dto.BlocksResponse;
import com.kbaez.rooftop.dto.CheckBlockResponse;
import com.kbaez.rooftop.dto.CheckResponse;
import com.kbaez.rooftop.dto.TokenResponse;
import com.kbaez.rooftop.dto.request.BlocksRequest;
import com.kbaez.rooftop.service.RooftopService;

@Service
public class RooftopServiceImpl implements RooftopService {

	private String URI_TOKEN = "https://rooftop-career-switch.herokuapp.com/token?email=";
	private String URI_BLOCKS = "https://rooftop-career-switch.herokuapp.com/blocks?token=";
	private String URI_CHECK = "https://rooftop-career-switch.herokuapp.com/check?token=";

	private RestTemplate restTemplate;
	
	@Autowired
	public RooftopServiceImpl(RestTemplate rest) {
		restTemplate =  rest;
	}

	@Override
	public TokenResponse getToken(String mail) {
		TokenResponse result = restTemplate.getForObject(URI_TOKEN + mail, TokenResponse.class);
		return result;
	}

	@Override
	public BlocksResponse getBlocks(String token) {
		BlocksResponse result = restTemplate.getForObject(URI_BLOCKS+ token, BlocksResponse.class);
		return result;
	}

	@Override
	public boolean checkBlocks(String token, BlocksRequest request) {
		CheckBlockResponse result = restTemplate.postForObject(URI_CHECK, request, CheckBlockResponse.class);
		return result.isMessage();
	}

	@Override
	public CheckResponse check(String token, BlocksRequest request) {
		URI_CHECK = URI_CHECK + token;
		String[] blocksArray = request.getBlocks();
		String aux;
		for (int i = 0; i < blocksArray.length; i++) {
			for (int j = i + 1; j < blocksArray.length; j++) {
				String[] data = { blocksArray[i], blocksArray[j] };
				BlocksRequest blocks = new BlocksRequest();
				blocks.setBlocks(data);
				if (checkBlocks(token, blocks)) {
					aux = blocksArray[i + 1];
					blocksArray[i + 1] = blocksArray[j];
					blocksArray[j] = aux;
					i++;
				}
			}
		}
		
		String allBlocks = "";
		for(String block: blocksArray) {
			allBlocks = allBlocks + block;
		}
		
		CheckResponse response = new CheckResponse();
		response.setEncoded(allBlocks);
		return response ;
	}
}
