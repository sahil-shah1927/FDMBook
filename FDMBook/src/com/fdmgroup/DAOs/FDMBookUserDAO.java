package com.fdmgroup.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.Models.FDMBookUser;

public class FDMBookUserDAO extends DAO<FDMBookUser>
{

	public FDMBookUserDAO(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void create(FDMBookUser newUser){
		
		EntityManager myEM = myFactory.createEntityManager();
		
		myEM.getTransaction().begin();
		myEM.persist(newUser);
		myEM.getTransaction().commit();
		myEM.close();
		
	}

	@Override
	public FDMBookUser read(FDMBookUser object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(FDMBookUser object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FDMBookUser object) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
