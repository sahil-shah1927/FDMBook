package com.fdmgroup.Commands;

import com.fdmgroup.DAOs.FDMafiaUserDAO;
import com.fdmgroup.Exceptions.PasswordMismatchException;
import com.fdmgroup.Exceptions.UserDoesNotExistException;
import com.fdmgroup.Models.FDMafiaUser;
import com.fdmgroup.Spring.ApplicationContextProvider;

public class AuthenticateCredentials 
{
	/**
	 * 
	 * @param username
	 * @param password
	 * @return FDMafiaUser if found
	 * @return null if not found
	 * @throws UserDoesNotExistException 
	 * @throws PasswordMismatchException
	 */
	public static FDMafiaUser execute(String username,String password) throws PasswordMismatchException, UserDoesNotExistException
	{
		FDMafiaUserDAO userDAO = (FDMafiaUserDAO) ApplicationContextProvider.getApplicationContext().getBean("FDMafiaUserDAO");
		FDMafiaUser loginUser = new FDMafiaUser();
		
		loginUser.setUsername(username);
		
		loginUser = userDAO.read(loginUser);//Exception Occurs Here if User doesn't exist
		if(loginUser.getPassword().equals(password))
		{
			return loginUser;
		}
		else
		{
			throw new PasswordMismatchException("Incorrect Password Credentials");
		}
		
	}
}
