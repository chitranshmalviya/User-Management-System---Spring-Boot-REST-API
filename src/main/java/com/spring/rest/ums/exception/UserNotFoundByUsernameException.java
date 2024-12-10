package com.spring.rest.ums.exception;

public class UserNotFoundByUsernameException extends BaseException {

	public UserNotFoundByUsernameException(String message) {
		super(message);
	}
}