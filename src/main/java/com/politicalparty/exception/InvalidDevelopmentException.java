package com.politicalparty.exception;

public class InvalidDevelopmentException extends RuntimeException {

	private static final long serialVersionUID = 2119010801632373899L;

	public InvalidDevelopmentException(String message)	{
		super(message);
	}
}