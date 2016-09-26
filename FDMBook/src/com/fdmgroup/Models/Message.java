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
public class Message {
	
	private String sentTo;

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
	
	 @Override
	    public String toString() {
	        return "{" +
	                "\"messageSentByUser\":\"" + messageSentByUser + '\"' +
	                ",\"userWhoCreatedMessage\":\"" + userWhoCreatedMessage + '\"' +
	                ",\"sentTo\":\"" + sentTo + '\"' +
	                ",\"timeStamp\":\"" + timeStamp + "\"" +
	                '}';
	
	 }

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}
	
}
