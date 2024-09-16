package com.saturnPulse.SaturnPulse.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO implements Serializable {

	private int status;
	private Boolean success;
	private String message;
	private Object data;
}
