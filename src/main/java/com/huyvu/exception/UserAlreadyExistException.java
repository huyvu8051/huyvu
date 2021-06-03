package com.huyvu.exception;

public class UserAlreadyExistException extends Exception {
	private static final long serialVersionUID = -4798079672430027028L;

	public UserAlreadyExistException(String errorMessage) {
		super(errorMessage);
	}

}
