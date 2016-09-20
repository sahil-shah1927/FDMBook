package com.fdmgroup.Commands;

import com.fdmgroup.DAOs.FDMafiaUserDAO;
import com.fdmgroup.Exceptions.UserAlreadyExistsException;
import com.fdmgroup.Models.FDMafiaUser;
import com.fdmgroup.Spring.ApplicationContextProvider;

public class RegisterUser 
{
	
	/**
	 * 
	 * @param newUser
	 * @return true if Success
	 * @return false if fail
	 */
	public static boolean execute(FDMafiaUser newUser)
	{
		FDMafiaUserDAO userDAO = (FDMafiaUserDAO) ApplicationContextProvider.getApplicationContext().getBean("FDMafiaUserDAO");

		try
		{
			userDAO.create(newUser);
			return true;
		}
		catch(UserAlreadyExistsException e)
		{
			return false;
		}
	}
}
