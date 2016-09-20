package com.fdmgroup.Main;

import com.fdmgroup.Models.Message;

public class Driver {
	public static void main(String[] arg){
		Message message = new Message();
		
		message.setTimeStamp();
		message.setMessageSentByUser("hello world");
		message.setUserWhoCreatedMessage("kishan");
		
		System.out.println(message.toString());
	}
}
