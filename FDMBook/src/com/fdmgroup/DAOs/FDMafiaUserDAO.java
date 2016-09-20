package com.fdmgroup.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		String username = userToBeRead.getUsername();
		
		//Create Query for User using username
		String queryString = "SELECT u FROM FDMafiaUser u WHERE u.username = :username";
		TypedQuery<FDMafiaUser> userQuery = myEM.createQuery(queryString, FDMafiaUser.class);
		userQuery.setParameter("username", username);
		
		//Attempt User Retrieval
		try
		{
			return (FDMafiaUser) userQuery.getSingleResult();
		}
		catch(NoResultException noResultException)
		{
			throw new UserDoesNotExistException("Username '" + username + "' is not registered!");
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
