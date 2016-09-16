package com.fdmgroup.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;




/**
 * 
 * @author Sahil Shah
 * @version 1.0
 * 
 * Basic POJO. No Persistence Available Yet.
 *
 */
@Entity
public class FDMBookUser 
{
	
	@Column
	private int userId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String emailAddress;
	
	@Column
	private String password;
	
	@Column
	private Date dateOfBirth;
	
	@Column
	private Date memberSince;
	
	/**
	 * Default Constructor
	 */
	public FDMBookUser()
	{
		
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the memberSince
	 */
	public Date getMemberSince() {
		return memberSince;
	}

	/**
	 * @param memberSince the memberSince to set
	 */
	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}
	
	
}
