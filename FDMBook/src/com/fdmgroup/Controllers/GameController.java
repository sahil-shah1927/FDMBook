package com.fdmgroup.Controllers;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.GameManagement.Game;
import com.fdmgroup.Models.FDMafiaUser;

@Controller
public class GameController 
{
	@Autowired
	private ServletContext appContext;
	
	
	@RequestMapping(value="/joinGame")
	public String JoinRoom(HttpServletRequest request,HttpServletResponse response)
	{
		

		HttpSession session = request.getSession();
		
		FDMafiaUser userToBeAdded = (FDMafiaUser)session.getAttribute("LoggedInUser");
		Game game =  (Game) appContext.getAttribute("game");

		
		game.addPlayer(userToBeAdded);
		Cookie cookie = new Cookie("role",game.getPlayers().get(userToBeAdded).getGameRole().toString());
		cookie.setMaxAge(21600);
		response.addCookie(cookie);
		appContext.setAttribute("game", game);
	    return "chat";
	    
	}
	
	
	
	
}
