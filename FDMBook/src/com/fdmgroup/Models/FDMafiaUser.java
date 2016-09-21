package com.fdmgroup.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




/**
 * 
 * @author Sahil Shah
 * @version 1.0
 * 
 * Basic POJO. No Persistence Available Yet.
 *
 */
@Entity
@Table
public class FDMafiaUser
{
	@Id
	private String username;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;

	@Column
	private String emailAddress;
	
	@Column
	private String password;
	
	
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.MERGE)
	@JoinTable(name = "USER_CHATROOM", joinColumns = {
	        @JoinColumn(name = "USERNAME")}, inverseJoinColumns = {
	        @JoinColumn(name = "ROOM_ID")})
	private List<ChatHistory> chatRoomsImIn;
	
	/**
	 * Default Constructor
	 */
	public FDMafiaUser()
	{
		
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}




	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public List<ChatHistory> getChatRoomsImIn() {
		return chatRoomsImIn;
	}

	public void setChatRoomsImIn(List<ChatHistory> chatRoomsImIn) {
		this.chatRoomsImIn = chatRoomsImIn;
	}
	
	
}
