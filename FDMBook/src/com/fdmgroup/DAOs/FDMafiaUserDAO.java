package com.fdmgroup.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.Models.FDMafiaUser;

public class FDMafiaUserDAO extends DAO<FDMafiaUser>
{

	public FDMafiaUserDAO(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void create(FDMafiaUser newUser){
		
		EntityManager myEM = myFactory.createEntityManager();
		
		myEM.getTransaction().begin();
		myEM.persist(newUser);
		myEM.getTransaction().commit();
		myEM.close();
		
	}

	@Override
	public FDMafiaUser read(FDMafiaUser object) throws Exception 
	{
		EntityManager myEM = myFactory.createEntityManager();
		
		String query = "SELECT FROM ";
		return null;
	}

	@Override
	public void update(FDMafiaUser object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FDMafiaUser object) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
