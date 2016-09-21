package com.fdmgroup.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import com.fdmgroup.Exceptions.UserAlreadyExistsException;
import com.fdmgroup.Exceptions.UserDoesNotExistException;
import com.fdmgroup.Models.FDMafiaUser;

public class FDMafiaUserDAO extends DAO<FDMafiaUser>
{

	public FDMafiaUserDAO(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void create(FDMafiaUser newUser) throws UserAlreadyExistsException
	{
		
		try
		{
			read(newUser);
			throw new UserAlreadyExistsException("Username '" + newUser.getUsername() + "' is already in use!");
		}
		catch(UserDoesNotExistException e)
		{
			EntityManager myEM = myFactory.createEntityManager();
			myEM.getTransaction().begin();
			myEM.persist(newUser);
			myEM.getTransaction().commit();
			myEM.close();
		}
		
	}

	@Override
	public FDMafiaUser read(FDMafiaUser userToBeRead) throws UserDoesNotExistException 
	{
		EntityManager myEM = myFactory.createEntityManager();
		
		//Attempt User Retrieval
		try
		{
			return myEM.find(FDMafiaUser.class, userToBeRead.getUsername());
		}
		catch(NoResultException noResultException)
		{
			throw new UserDoesNotExistException("Username '" + userToBeRead.getUsername() + "' is not registered!");
		}
		finally
		{
			myEM.close();
		}
	}

	@Override
	public void update(FDMafiaUser userToBeUpdated) 
	{
		EntityManager myEM = myFactory.createEntityManager();
		
		myEM.getTransaction().begin();
		myEM.merge(userToBeUpdated);
		myEM.getTransaction().commit();
		myEM.close();
	}

	@Override
	public void delete(FDMafiaUser object) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
