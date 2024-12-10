package com.spring.rest.ums.exception;

public class UserNotFoundByIdException extends BaseException {
	
	public UserNotFoundByIdException(String message) {
		super(message);
	}
}