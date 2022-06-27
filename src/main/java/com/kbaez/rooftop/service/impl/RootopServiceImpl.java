package com.kbaez.rooftop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kbaez.rooftop.dto.BlocksResponse;
import com.kbaez.rooftop.dto.CheckBlockResponse;
import com.kbaez.rooftop.dto.CheckResponse;
import com.kbaez.rooftop.dto.TokenResponse;
import com.kbaez.rooftop.dto.request.BlocksRequest;
import com.kbaez.rooftop.dto.request.CheckRequest;
import com.kbaez.rooftop.service.RootopService;

@Service
public class RootopServiceImpl implements RootopService {

	private String URI_TOKEN = "https://rooftop-career-switch.herokuapp.com/token?email=";
	private String URI_BLOCKS = "https://rooftop-career-switch.herokuapp.com/blocks?token=";
	private String URI_CHECK = "https://rooftop-career-switch.herokuapp.com/check?token=";

	@Override
	public TokenResponse getToken(String mail) {
		URI_TOKEN = URI_TOKEN + mail;
		RestTemplate restTemplate = new RestTemplate();
		TokenResponse result = restTemplate.getForObject(URI_TOKEN, TokenResponse.class);
		return result;
	}

	@Override
	public BlocksResponse getBlocks(String token) {
		URI_BLOCKS = URI_BLOCKS + token;
		RestTemplate restTemplate = new RestTemplate();
		BlocksResponse result = restTemplate.getForObject(URI_BLOCKS, BlocksResponse.class);
		return result;
	}

	@Override
	public boolean checkBlocks(String token, BlocksRequest request) {
		RestTemplate restTemplate = new RestTemplate();
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
