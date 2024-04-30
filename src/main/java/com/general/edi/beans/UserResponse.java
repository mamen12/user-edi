package com.general.edi.beans;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	@JsonProperty(value = "userid")
	private Long userId;
	
	@JsonProperty(value = "namalengkap")
	private String namaLengkap;

	@JsonProperty(value = "username")
	private String username;

	private Character status;
	
	private String message;
}
