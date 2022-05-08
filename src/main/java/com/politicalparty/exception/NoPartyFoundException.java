package com.politicalparty.exception;

public class NoPartyFoundException extends RuntimeException {

	private static final long serialVersionUID = 2119010801632373899L;

	public NoPartyFoundException(String message)	{
		super(message);
	}
}