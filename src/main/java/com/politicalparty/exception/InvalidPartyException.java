package com.politicalparty.exception;

public class InvalidPartyException extends RuntimeException {

	private static final long serialVersionUID = 2119010801632373899L;

	public InvalidPartyException(String message)	{
		super(message);
	}
}