package com.general.edi.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class UserRequest {
	@JsonProperty(value = "userid")
	private Long userId;
	@JsonProperty(value = "namalengkap")
	private String namaLengkap;
	private String username;
	private String password;
	private Character status;
	@JsonProperty(value = "all")
	private String allUser;
	
	
}

