package com.fdmgroup.Models;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
/**
 * Functions as the chat room in which Users can send messages. 
 * A ChatHistory can contain many Users and many messages.
 * @author Kishan
 *
 */
@Entity
@Table(name="Chats")
public class ChatHistory implements Serializable, Comparable<ChatHistory>{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2492158655805446779L;


	public ChatHistory(){
		
	}
	
	String uniqueID;
	
	@Type(type ="true_false")
	boolean privacy;
	
	public boolean getPrivacy() {
		return privacy;
	}

	public void setPrivacy(boolean privacy) {
		this.privacy = privacy;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private String timeStamp;
	private String chatMessageLogURL;

	@Column(name="ROOM_NAME")
	private String chatRoomName;
	
	@Column(name="ROOM_CREATOR")
	private String chatCreator;
	
//	@ManyToMany(fetch=FetchType.EAGER,mappedBy = "chatRoomsImIn",cascade=CascadeType.MERGE)
//	private List<FDMafiaUser> usersInChatRoom;

	
	public ChatHistory(String chatRoomName){
		
		
		this.setTimeStamp();
		
		this.chatRoomName=chatRoomName;
		//this.usersInChatRoom=new ArrayList<FDMafiaUser>();
		
		
	}
	
	

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public String getChatCreator() {
		return chatCreator;
	}

	public void setChatCreator(String chatCreator) {
		this.chatCreator = chatCreator;
	}



	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}

//	public List<FDMafiaUser> getUsersInChatRoom() {
//		return usersInChatRoom;
//	}
//
//	public void setUsersInChatRoom(List<FDMafiaUser> usersInChatRoom) {
//		this.usersInChatRoom = usersInChatRoom;
//	}
//
//	
//	public void addUser(FDMafiaUser user){
//		usersInChatRoom.add(user);
//	}
	public void addMessage(Message msg) {
	
		
	}


	public String getChatMessageLogURL() {
		return chatMessageLogURL;
	}

	public void setChatMessageLogURL() {
		this.chatMessageLogURL = (uniqueID+"_"+chatCreator+"_"+chatRoomName +".txt") ;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp() {
		this.timeStamp = new SimpleDateFormat(" MMM d, yyyy 'at' h:mm a").format(new java.util.Date());
	}

	

	@Override
	public int compareTo(ChatHistory ch) {
		return this.id < ch.id ? -1 : this.id == ch.id ? 0 : 1;
	}

	
	
	
}
