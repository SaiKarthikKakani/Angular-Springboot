package com.politicalparty.exception;

public class InvalidPartyLeaderException extends RuntimeException {

	private static final long serialVersionUID = 2119010801632373899L;

	public InvalidPartyLeaderException(String message)	{
		super(message);
	}
}