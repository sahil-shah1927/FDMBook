package com.fdmgroup.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Lawrence Leo
 *
 */
@Controller
public class DirectoryController {
	
	
	@RequestMapping(value="/")
	public String goIndex(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String goLogin(HttpSession session) 
	{
		return "login";
	}
	
	@RequestMapping("/chat")
	public String goChat(){
		return "chat";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String redirectLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String redirectHome() {
		return "home";
	}
}
