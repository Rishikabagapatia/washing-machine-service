package com.wash.machine.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.wash.machine.entity.ExceptionResponse;

@ControllerAdvice
public class CustomizedResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	  @ExceptionHandler(Exception.class)
	   public ResponseEntity<ExceptionResponse> handleAllException(Exception ex) {		  
		   ExceptionResponse response = new ExceptionResponse(new Date(),ex.getMessage());
	       return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	  
	  @ExceptionHandler(DataNotFoundException.class)
	   public ResponseEntity<ExceptionResponse> handleDataNotFoundException(DataNotFoundException ex) {		  
		   ExceptionResponse response = new ExceptionResponse(new Date(),ex.getMessage());
	       return new ResponseEntity(response,HttpStatus.NOT_FOUND);
	   }
	  
	  @ExceptionHandler(RuntimeException.class)
	   public ResponseEntity<ExceptionResponse> handleDataExistException(RuntimeException ex) {		  
		   ExceptionResponse response = new ExceptionResponse(new Date(),ex.getMessage());
	       return new ResponseEntity(response,HttpStatus.CONFLICT);
	   }

}
