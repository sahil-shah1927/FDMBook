package com.fdmgroup.Exceptions;

public class PasswordMismatchException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1171807725004817074L;

	public PasswordMismatchException()
	{
		super();
	}
	
	public PasswordMismatchException(String errorMessage)
	{
		super(errorMessage);
	}
	
	public PasswordMismatchException(Throwable throwable)
	{
		super(throwable);
	}
	
	public PasswordMismatchException(String errorMessage, Throwable throwable)
	{
		super(errorMessage,throwable);
	}
}
