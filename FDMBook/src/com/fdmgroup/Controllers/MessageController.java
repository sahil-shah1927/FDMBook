package com.fdmgroup.Controllers;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.DAOs.FileReadCommand;
import com.fdmgroup.DAOs.FileWriteCommand;
import com.fdmgroup.Models.Message;
import com.fdmgroup.Models.MessageJSON;

@Controller
public class MessageController {

	 @RequestMapping(value = "/messages", method = RequestMethod.POST)
	    @MessageMapping("/newMessage")
	    @SendTo("/topic/newMessage")
	    public MessageJSON save(Message message) {
		 	FileWriteCommand fwc = new FileWriteCommand();
		 	FileReadCommand frc = new FileReadCommand();
		 	String path = "H:/git/FDMBook/FDMBook/WebContent/WEB-INF/ChatLogs/test.txt";
		 	fwc.writeMessage(path, message);
	        List<String> messageList = frc.readMessages(path);
	        return new MessageJSON(messageList.toString());
	    }

	    @RequestMapping(value = "/messages", method = RequestMethod.GET)
	    public HttpEntity<List<String>> list() {
	    	FileReadCommand frc = new FileReadCommand();
	    	String path = "H:/git/FDMBook/FDMBook/WebContent/WEB-INF/ChatLogs/test.txt";
	        List<String> messageList = frc.readMessages(path);
	        return new ResponseEntity<List<String>>(messageList, HttpStatus.OK);
	    }
	
}
