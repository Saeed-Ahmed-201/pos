package com.pos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	   @ResponseBody
	   @ExceptionHandler(CustomException.class)
	   public ResponseEntity<ExceptionResponse> handleCustomException(CustomException ex){
		      ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
		      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	   }
	   
}
