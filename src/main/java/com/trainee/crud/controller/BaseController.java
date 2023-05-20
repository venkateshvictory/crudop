package com.trainee.crud.controller;

import com.trainee.crud.customer.dto.ResponseDto;

public class BaseController {

   public void prepareResponse(ResponseDto response,String httpStatusCode, String message, Integer statuscode) {
	   response.setHttpStatusCode(statuscode);
	   response.setMessage(message);
	   response.setStatus(httpStatusCode);
   }
   
   public ResponseDto prepareExceptionResponse(RuntimeException exception,ResponseDto responseDto) {
	prepareResponse(responseDto, "failed", exception.getMessage(), 500);
	return responseDto;
	   
   }
   	
   
}
