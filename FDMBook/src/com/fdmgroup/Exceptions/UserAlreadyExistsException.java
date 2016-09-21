package com.fdmgroup.Exceptions;

public class UserAlreadyExistsException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1056287311777555218L;

	public UserAlreadyExistsException()
	{
		super();
	}
	
	public UserAlreadyExistsException(String errorMessage)
	{
		super(errorMessage);
	}
	
	public UserAlreadyExistsException(Throwable throwable)
	{
		super(throwable);
	}
	
	public UserAlreadyExistsException(String errorMessage, Throwable throwable)
	{
		super(errorMessage,throwable);
	}
}
