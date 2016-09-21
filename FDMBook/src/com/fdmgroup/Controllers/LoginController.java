package com.fdmgroup.Controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.Commands.AuthenticateCredentials;
import com.fdmgroup.Exceptions.PasswordMismatchException;
import com.fdmgroup.Exceptions.UserDoesNotExistException;
import com.fdmgroup.Models.FDMafiaUser;

/**
 * 
 * @author Sahil Shah
 *
 */
@Controller
public class LoginController 
{
	
	@RequestMapping(value="/LoginUser",method = RequestMethod.POST)
	public String loginUser(Model model, HttpServletRequest request, HttpSession session,HttpServletResponse response)
	{
		FDMafiaUser loginUser;
		try 
		{
			loginUser = AuthenticateCredentials.execute(
					request.getParameter("username"),request.getParameter("password"));
			
			session.setAttribute("LoggedInUser", loginUser);//Successful Login
			response.addCookie(new Cookie("realtime-chat-nickname", request.getParameter("username")));
			return "home";
			
		} 
		catch (PasswordMismatchException | UserDoesNotExistException loginException)
		{
			//Incorrect Password or User Does Not Exist
			
			session.setAttribute("LoginError", loginException.getMessage());
			return "login";				
		} 
	}
	
	@RequestMapping(value="/logout")
	public String logoutUser(HttpSession session)
	{
		session.removeAttribute("LoggedInUser");
		session.removeAttribute("LoginError");
		return "login";
	}
}
