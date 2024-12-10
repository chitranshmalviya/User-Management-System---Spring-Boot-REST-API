package com.spring.rest.ums.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.rest.ums.util.ErrorStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundById(UserNotFoundByIdException ex) {
/**
 * HttpStatus -> is a ENUM that provide different HttpStatus type such as NOT_FOUND, FOUND, FORBIDDEN etc
 * value() -> for converting HttpStatus in form for numeric we user this method 
 * name()  -> for converting HttpStatus in form for String we user this method 
 */
	return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),
				"user not found by the given id"));
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> handleUserNotFoundByUsername(UserNotFoundByUsernameException ex) {
		/**
		 * HttpStatus -> is a ENUM that provide different HttpStatus type such as NOT_FOUND, FOUND, FORBIDDEN etc
		 * value() -> for converting HttpStatus in form for numeric we user this method 
		 * name()  -> for converting HttpStatus in form for String we user this method 
		 */
				
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(ErrorStructure.create(HttpStatus.NOT_FOUND.value(),ex.getMessage(),
						"user not found by the given Username"));
			}
	
}
