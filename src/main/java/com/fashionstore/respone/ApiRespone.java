package com.fashionstore.respone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
@JsonInclude(value = Include.NON_NULL)
@Builder
public class ApiRespone<Result> {
	
	@Builder.Default
	private int code =2500;
	private String message;
	private Result result;
	
	
}
