package com.politicalparty.exception;

public class NoPartyLeaderFoundException extends RuntimeException {

	private static final long serialVersionUID = 2119010801632373899L;

	public NoPartyLeaderFoundException(String message)	{
		super(message);
	}
}