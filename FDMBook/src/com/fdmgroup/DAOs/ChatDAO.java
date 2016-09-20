package com.fdmgroup.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.fdmgroup.Models.ChatHistory;

/**
 * 
 * @author Kishan Patel
 *
 */
public class ChatDAO implements Storage<ChatHistory> {

	
	private EntityManagerFactory emf;

	
	
	public ChatDAO(EntityManagerFactory emf){
		this.emf=emf;
	}
	
	/**
	 * Persist ChatHistory to database.
	 * @param chat - ChatHistory to be persisted;
	 */
	public void create(ChatHistory chat) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(chat);
		tx.commit();	
		em.close();
	}

	/**
	 * Read information about ChatHistory with given uniqueID from database.
	 * @param chatRoomName
	 * @return
	 */
	
	public ChatHistory read(String uniqueID) {
		EntityManager em = emf.createEntityManager();
		try {
			Query query = em.createNativeQuery("SELECT ch FROM ChatHistory ch WHERE LOWER(ch.uniqueID) = LOWER(:uniqueID)",ChatHistory.class);
			query.setParameter("uniqueID", uniqueID);
			ChatHistory chatRoom = (ChatHistory) query.getSingleResult();
			em.close();

			return chatRoom;
			} catch (NoResultException n){
				
			}
			return null;
	}

	/**
	 * Read information of all existing public chat rooms from the database.
	 * @return chatRooms - List of all public chat rooms.
	 */
	public List<ChatHistory> readAll() {
		EntityManager em = emf.createEntityManager();
		Query userQuery =
				em.createNativeQuery("SELECT ch FROM ChatHistory ch WHERE ch.privacy=FALSE", ChatHistory.class);
		List<ChatHistory> chatRooms = userQuery.getResultList();
		em.close();

		return chatRooms;
	}

	

	/**
	 * @param chat - ChatHistory that is to be updated on database.
	 */
	public void update(ChatHistory chat) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(chat);
		tx.commit();
		em.close();

		
	}


	/**
	 * @param chat - ChatHistory that will be deleted from database.
	 */
	public void delete(ChatHistory chat) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(chat);
		tx.commit();
		em.close();

		
	}

	
	public ChatHistory read(ChatHistory t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

}
