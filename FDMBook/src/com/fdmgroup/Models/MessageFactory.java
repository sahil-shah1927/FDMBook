package com.fdmgroup.Models;

/**
 * 
 * @author Kishan
 *
 */
public class MessageFactory {
	
	public MessageFactory(){
	}
	
	public static Message createMessage(String message){
			return new Message(message);
	}
}
