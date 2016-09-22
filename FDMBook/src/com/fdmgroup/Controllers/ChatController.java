package com.fdmgroup.Controllers;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.Models.ChatHistory;
import com.fdmgroup.Models.Message;
import com.fdmgroup.Spring.ApplicationContextProvider;
import com.fdmgroup.Models.FDMafiaUser;
/**
 * 
 * @author Kishan
 *
 */
@Controller(value="chat")
public class ChatController {
	
	  
	ApplicationContextProvider acp = new ApplicationContextProvider();
	
	/**
	 * Create a new chat room with name input by client, along with a chat log for the chat room.
	 * @param chat - Model bean used as template for new chat room as it is created.
	 * @param session - Current session of a client.
	 * @param model - Current model of client containing request information.
	 * @return
	 * @throws IOException
	 */
//	@RequestMapping("/createChat")
//	public String createNewChat(@ModelAttribute("chat") ChatHistory chat,HttpSession session,Model model) throws IOException{
//		model.addAttribute("chat", (ChatHistory)acp.getApplicationContext().getBean("chat"));
//		model.addAttribute("message", (Message)acp.getApplicationContext().getBean("message"));
//
//		DatabaseWriteCommand dbwc = (DatabaseWriteCommand) acp.getApplicationContext().getBean("databaseWriteCommand");
//		FileWriteCommand fwc = (FileWriteCommand) acp.getApplicationContext().getBean("fileWriteCommand");
//		
//		ChatHistory newChat = chat;
//		
//		newChat.setTimeStamp();
//		newChat.setChatCreator(((User)session.getAttribute("currentUser")).getUsername());
//		newChat.setUniqueID(UUID.randomUUID().toString());
//		newChat.setChatMessageLogURL();
//		newChat.setPrivacy(false);
//		
//				
//	
//		fwc.newChatLog(newChat);
//		dbwc.createChatRoom(newChat);
//		
//		session.setAttribute("alertMessage", "<div class='alert info'><span class='closebtn'>&times;</span><strong>Info!</strong> A new chat room called '" + newChat.getChatRoomName() +"' has been created.</div>");
//	
//		return "ChatPage";
//		
//	}
	
	
	
	/**
	 * Join an existing chat room.
	 * @param session - Current session of a client.
	 * @param model - Current model of client containing request information.
	 * @return
	 */
	@RequestMapping(value = " /joinChat/**", method=RequestMethod.GET)
	public String joinChat(Model model, HttpServletRequest request,HttpSession session){
		model.addAttribute("chat", (ChatHistory)acp.getApplicationContext().getBean("chat"));
		model.addAttribute("message", (Message)acp.getApplicationContext().getBean("message"));

//		DatabaseReadCommand dbrc = (DatabaseReadCommand) acp.getApplicationContext().getBean("databaseReadCommand");
//		DatabaseWriteCommand dbwc = (DatabaseWriteCommand) acp.getApplicationContext().getBean("databaseWriteCommand");

		
		String uniqueID = request.getParameter("id");
//		ChatHistory newCurrentChat = dbrc.readChatHistory(uniqueID);
//		dbwc.joinChatRoom(((User)session.getAttribute("currentUser")).getUsername(),uniqueID);
		
//		session.setAttribute("currentUser", dbrc.readUser(((User)session.getAttribute("currentUser")).getUsername()));
//		session.setAttribute("currentChatRoom", newCurrentChat);

//		session.setAttribute("alertMessage", "<div class='alert info'><span class='closebtn'>&times;</span><strong>Info!</strong> You have joined the chat room '" + newCurrentChat.getChatRoomName() +"'.</div>");

		return "chat";
	}
	

	/**
	 * Leave a chat room that you are in currently.
	 * @param model - Current model of client containing request information.
	 * @param session - Current session of a client.
	 * @return
	 */
//	@RequestMapping("/leaveChat")
//	public String leaveChat(Model model,HttpSession session){
//		model.addAttribute("chat", (ChatHistory)acp.getApplicationContext().getBean("chat"));
//		model.addAttribute("message", (Message)acp.getApplicationContext().getBean("message"));
//		
//		DatabaseReadCommand dbrc = (DatabaseReadCommand) acp.getApplicationContext().getBean("databaseReadCommand");
//		DatabaseWriteCommand dbwc = (DatabaseWriteCommand) acp.getApplicationContext().getBean("databaseWriteCommand");
//
//	
//		if(dbrc.equals((ChatHistory)session.getAttribute("currentChatRoom"),((ChatHistory)session.getAttribute("currentChatRoom")).getId())){
//			session.setAttribute("alertMessage", "<div class='alert info'><span class='closebtn'>&times;</span><strong>Info!</strong> You have left the chat room '" + ((ChatHistory)session.getAttribute("currentChatRoom")).getChatRoomName() +"'.</div>");
//
//			dbwc.leaveChatRoom((User)session.getAttribute("currentUser"),((ChatHistory)session.getAttribute("currentChatRoom")).getUniqueID());
//			session.setAttribute("currentChatRoom", null);
//
//		}else{
//			session.setAttribute("alertMessage", "<div class='alert info'><span class='closebtn'>&times;</span><strong>Info!</strong> You have left the chat room '" + ((ChatHistory)session.getAttribute("currentChatRoom")).getChatRoomName() +"'.</div>");
//
//			dbwc.leaveChatRoom((User)session.getAttribute("currentUser"),((ChatHistory)session.getAttribute("currentChatRoom")).getUniqueID());
//
//		}
//
//		session.setAttribute("currentUser", dbrc.readUser(((User)session.getAttribute("currentUser")).getUsername()));
//
//		
//		return "ChatPage";
//	}
	
	/**
	 * Create a new private chat room that can only be accessed by user who created room and person who is receiving the private message.
	 * Cannot be rejoined if left.
	 * @param request
	 * @param session
	 * @param model
	 * @return
	 * @throws IOException
	 */
//	@RequestMapping("/newPM")
//	public String createNewPrivateChat(HttpServletRequest request,HttpSession session,Model model) throws IOException{
//		model.addAttribute("chat", (ChatHistory)acp.getApplicationContext().getBean("chat"));
//		model.addAttribute("message", (Message)acp.getApplicationContext().getBean("message"));
//		
//		DatabaseReadCommand dbrc = (DatabaseReadCommand) acp.getApplicationContext().getBean("databaseReadCommand");
//		DatabaseWriteCommand dbwc = (DatabaseWriteCommand) acp.getApplicationContext().getBean("databaseWriteCommand");
//		FileWriteCommand fwc = (FileWriteCommand) acp.getApplicationContext().getBean("fileWriteCommand");
//		
//		ChatHistory newChat = (ChatHistory)acp.getApplicationContext().getBean("emptychat");		
//		
//		if(!((User)session.getAttribute("currentUser")).getUsername().equals(request.getParameter("friendName"))){
//		
//			
//			
//		newChat.setChatRoomName(request.getParameter("privateRoom"));
//		newChat.setTimeStamp();
//		newChat.setChatCreator(((User)session.getAttribute("currentUser")).getUsername());
//		newChat.setUniqueID(UUID.randomUUID().toString());
//		newChat.setChatMessageLogURL();
//		newChat.setPrivacy(true);
//		
//		
//		fwc.newChatLog(newChat);
//		dbwc.createChatRoom(newChat);
//		
//		
//		dbwc.joinChatRoom(request.getParameter("friendName"), newChat.getUniqueID());
//        dbwc.joinChatRoom(((User)session.getAttribute("currentUser")).getUsername(),newChat.getUniqueID());
//		
//		session.setAttribute("currentUser", dbrc.readUser(((User)session.getAttribute("currentUser")).getUsername()));
//		session.setAttribute("currentChatRoom", newChat);
//		
//		session.setAttribute("alertMessage", "<div class='alert info'><span class='closebtn'>&times;</span><strong>Info!</strong> You are now messaging the user '" + request.getParameter("friendName") +"'.</div>");
//
//		
//		}
//		return "ChatPage";
//		
//	}

	
	
}
