package com.fdmgroup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String goLogin() {
		return "login";
	}
	
	@RequestMapping("/chat")
	public String goChat(){
		return "chat";
	}
	
}
