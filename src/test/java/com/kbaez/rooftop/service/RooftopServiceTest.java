package com.kbaez.rooftop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import com.kbaez.rooftop.dto.CheckBlockResponse;
import com.kbaez.rooftop.dto.CheckResponse;
import com.kbaez.rooftop.dto.request.BlocksRequest;
import com.kbaez.rooftop.service.impl.RooftopServiceImpl;

public class RooftopServiceTest {
	
	@Mock
	private RestTemplate restTemplate;
	private RooftopService rooftopService;
	
	@BeforeEach
	public void setUp() {
		restTemplate = Mockito.mock(RestTemplate.class);
		rooftopService = new RooftopServiceImpl(restTemplate);
	}

	@Test
	public void testCheckReturnCheckResponse() {
		CheckResponse expectedCheckResponse = new CheckResponse();
		expectedCheckResponse.setEncoded(
				"F0gUU2TQPe9fg023U1vPFcwna7IQQyr362RNenYOa2ReTty1aoIh1mYHXB2jGkW825VBEQl2Xkr06AGiQguJbMysx2pWDcVtSdE8KokzhmizqlWCXocJO1eXAuMW9JYx0Ba0HSW4TKnKtzI1chHoYQVXAKrF8go87g2c1CU1jjiRLiAi2hQs7IBn7huLokLKqFpZvFS4SjkZvFcLV77eOWiuL4zkyJsdjgRGAu6dyyrVBkcmISKv0YJXWmQiJNnEzKzIcWnkW5yaKiCJ0SenSrYPuRQY2TE7Y6p5KpNugIBkyJUg341qdmeEFuZqQCEFjfaM0zSVCt5mEliIdpjY0mBaiqqbojjy8J9BKiG9cPBFNfe8fRfttBemXnCmj4wXbj8Of04dGNwd5xERWzsb03mUqttlQaywXiAL5v7ouRH963Ctq42AxExB7TN4DCQb1z8VzZBHOJJPR82RB3Hu04fMu12gYIrQ6jCLjQAhK2QsrOl4ONsDZc8CzGBAFX1Gi24tCXipDRIFR0HtDc9KwxV2Pezwz2dHiZmqNbwNCPHDoY8CUUUhsG7JBOGru1UvkYNJATOs4JozuSi6BzVT0MdNUMd39X88TsokdFbHymURR2wm8nnkMqHVT17N7PrnLE2zo9ofRXYzF5xtiruD1cTVdRZsIYSw7QKoH8iq5PncoROjUbS9TFgQqZKCNc3FGEQNHoEBYakpuw91DiWdnIhUvC3OiokkU2eoprarpoLnkp4aEGaz6jCBUl2ql4DrYTqJ2H8HSoU8bMTFJtMxovJIl5t95CIQxJzqcjGFNR8sUspOzw7KMOgmidaZ1oqgBDKl6HwbzukCKHj1cJmxcCuDexTZQhozGJiR7W1ZM1tE6tbFXzSKzabYjpv2BFz0vm1q");
		String token = "e9371ae9-fde2-4c85-ab40-6cef5391586d";
		BlocksRequest blocksRequest = new BlocksRequest();
		blocksRequest.setBlocks(new String[] {
				"F0gUU2TQPe9fg023U1vPFcwna7IQQyr362RNenYOa2ReTty1aoIh1mYHXB2jGkW825VBEQl2Xkr06AGiQguJbMysx2pWDcVtSdE8",
				"KokzhmizqlWCXocJO1eXAuMW9JYx0Ba0HSW4TKnKtzI1chHoYQVXAKrF8go87g2c1CU1jjiRLiAi2hQs7IBn7huLokLKqFpZvFS4",
				"SjkZvFcLV77eOWiuL4zkyJsdjgRGAu6dyyrVBkcmISKv0YJXWmQiJNnEzKzIcWnkW5yaKiCJ0SenSrYPuRQY2TE7Y6p5KpNugIBk",
				"yJUg341qdmeEFuZqQCEFjfaM0zSVCt5mEliIdpjY0mBaiqqbojjy8J9BKiG9cPBFNfe8fRfttBemXnCmj4wXbj8Of04dGNwd5xER",
				"Wzsb03mUqttlQaywXiAL5v7ouRH963Ctq42AxExB7TN4DCQb1z8VzZBHOJJPR82RB3Hu04fMu12gYIrQ6jCLjQAhK2QsrOl4ONsD",
				"Zc8CzGBAFX1Gi24tCXipDRIFR0HtDc9KwxV2Pezwz2dHiZmqNbwNCPHDoY8CUUUhsG7JBOGru1UvkYNJATOs4JozuSi6BzVT0MdN",
				"UMd39X88TsokdFbHymURR2wm8nnkMqHVT17N7PrnLE2zo9ofRXYzF5xtiruD1cTVdRZsIYSw7QKoH8iq5PncoROjUbS9TFgQqZKC",
				"Nc3FGEQNHoEBYakpuw91DiWdnIhUvC3OiokkU2eoprarpoLnkp4aEGaz6jCBUl2ql4DrYTqJ2H8HSoU8bMTFJtMxovJIl5t95CIQ",
				"xJzqcjGFNR8sUspOzw7KMOgmidaZ1oqgBDKl6HwbzukCKHj1cJmxcCuDexTZQhozGJiR7W1ZM1tE6tbFXzSKzabYjpv2BFz0vm1q" });
		CheckBlockResponse checkBlockResponse = new CheckBlockResponse();
		checkBlockResponse.setMessage(true);

		when(restTemplate.postForObject(Mockito.any(String.class), 
                Mockito.any(),
                Mockito.eq(CheckBlockResponse.class)))
               .thenReturn(checkBlockResponse);
		CheckResponse response = rooftopService.check(token, blocksRequest);
		assertEquals(expectedCheckResponse, response);
	}
}
