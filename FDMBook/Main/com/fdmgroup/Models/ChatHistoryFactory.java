package com.fdmgroup.Models;
/**
 * 
 * @author Kishan
 *
 */
public class ChatHistoryFactory {
		
	public ChatHistoryFactory(){
		
	}
		
		public static ChatHistory createChatHistory(String chatRoomName) {
			ChatHistory newChat = new ChatHistory(chatRoomName);
			return newChat;
		}

	
}
