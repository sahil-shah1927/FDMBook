package com.fdmgroup.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.Commands.RegisterUser;
import com.fdmgroup.Models.FDMafiaUser;

/**
 * 
 * @author Sahil Shah
 *
 */
@Controller
public class RegistrationController 
{
	@RequestMapping(value="/RegisterUser",method = RequestMethod.POST)
	public String RegisterUser(Model model, HttpServletRequest request, HttpSession session)
	{
		FDMafiaUser newUser = new FDMafiaUser();
		newUser.setUsername(request.getParameter("username"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setFirstName(request.getParameter("firstname"));
		newUser.setLastName(request.getParameter("lastname"));
		newUser.setEmailAddress(request.getParameter("email"));
		
		if(RegisterUser.execute(newUser)){

			session.setAttribute("LoginError", "User created!");
			return "redirect:/login";
		} else	{
			session.setAttribute("LoginError", "Username already exists");
			return "redirect:/login";
		}
		
	}
}
