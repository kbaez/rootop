package com.kbaez.rooftop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class BlocksResponse {
	@JsonProperty("data")
	private String[] data;
	
	@JsonProperty("chunkSize")
	private String chunkSize;
	
	@JsonProperty("length")
	private String length;
}
