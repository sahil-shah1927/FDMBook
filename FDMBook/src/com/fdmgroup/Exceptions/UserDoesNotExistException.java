package com.fdmgroup.Exceptions;

public class UserDoesNotExistException extends Exception 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3399284821015626626L;
	
	public UserDoesNotExistException()
	{
		super();
	}
	
	public UserDoesNotExistException(String errorMessage)
	{
		super(errorMessage);
	}
	
	public UserDoesNotExistException(Throwable throwable)
	{
		super(throwable);
	}
	
	public UserDoesNotExistException(String errorMessage, Throwable throwable)
	{
		super(errorMessage,throwable);
	}

}
