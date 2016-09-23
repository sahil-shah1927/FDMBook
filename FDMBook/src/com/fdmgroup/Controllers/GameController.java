package com.fdmgroup.Controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.GameManagement.Game;
import com.fdmgroup.Models.FDMafiaUser;

@Controller
public class GameController 
{
	@RequestMapping(value="/joinGame")
	public String JoinRoom(HttpServletRequest request, HttpSession session)
	{
		ServletContext appContext = request.getSession().getServletContext();
		FDMafiaUser userToBeAdded = (FDMafiaUser)session.getAttribute("LoggedInUser");
		Game game =  (Game) appContext.getAttribute("game");
		if(game.isFull()){
			
		} 
		
		
		game.addPlayer(userToBeAdded);
		System.out.println(userToBeAdded.getUsername() + " has joined as " + game.getPlayers().get(userToBeAdded).getGameRole());
		appContext.setAttribute("game", game);
	
		return "chat";
		
	}
}
