package com.politicalparty.exception;

public class NoDevelopmentFoundException extends RuntimeException {

	private static final long serialVersionUID = 2119010801632373899L;

	public NoDevelopmentFoundException(String message)	{
		super(message);
	}
}