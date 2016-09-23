package com.fdmgroup.Controllers;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fdmgroup.DAOs.FileReadCommand;
import com.fdmgroup.DAOs.FileWriteCommand;
import com.fdmgroup.GameManagement.Game;
import com.fdmgroup.Models.FDMafiaUser;
import com.fdmgroup.Models.Message;

@Controller
public class GameController 
{
	@RequestMapping(value="/joinGame")
	@MessageMapping("/joinGame")
	public void JoinRoom(Message message)
	{
		FileWriteCommand fwc = new FileWriteCommand();
	 	String path = "H:/git/FDMBook/FDMBook/WebContent/WEB-INF/ChatLogs/test.txt";
	 	fwc.writeMessage(path, message);
		ServletContext appContext = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession().getServletContext();
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
		FDMafiaUser userToBeAdded = (FDMafiaUser)session.getAttribute("LoggedInUser");
		Game game =  (Game) appContext.getAttribute("game");
		if(game.isFull()){
			
		} 

	
		game.addPlayer(userToBeAdded);
		System.out.println(userToBeAdded.getUsername() + " has joined as " + game.getPlayers().get(userToBeAdded).getGameRole());
		appContext.setAttribute("game", game);
		
	}
	
	
}
