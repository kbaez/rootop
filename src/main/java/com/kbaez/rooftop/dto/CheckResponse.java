package com.kbaez.rooftop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kbaez.rooftop.dto.request.CheckRequest;

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
public class CheckResponse {
	@JsonProperty("data")
	private String[] data;
}
