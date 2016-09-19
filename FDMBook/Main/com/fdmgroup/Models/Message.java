package com.fdmgroup.Models;



import java.text.SimpleDateFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Kishan
 *
 */
public class Message implements Comparable<Message> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int message_id;
	


	private String messageSentByUser;
	
	private String timeStamp;

	private String userWhoCreatedMessage;
	
	public Message(String message){
		this.messageSentByUser=message;
	}
	
	public Message(){
		
	}


	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp() {
		this.timeStamp = new SimpleDateFormat("h:mm a").format(new java.util.Date());
	}


	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	
	@Override
	public int compareTo(Message msg) {
		return this.message_id < msg.message_id ? -1 : this.message_id == msg.message_id ? 0 : 1;
	}


	public String getMessageSentByUser() {
		return messageSentByUser;
	}

	public void setMessageSentByUser(String messageSentByUser) {
		this.messageSentByUser = messageSentByUser;
	}

	public String getUserWhoCreatedMessage() {
		return userWhoCreatedMessage;
	}

	public void setUserWhoCreatedMessage(String userWhoCreatedMessage) {
		this.userWhoCreatedMessage = userWhoCreatedMessage;
	}
	
}
