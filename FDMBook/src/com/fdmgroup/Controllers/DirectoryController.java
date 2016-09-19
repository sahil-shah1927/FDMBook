package com.fdmgroup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DirectoryController {
	
	
	@RequestMapping(value="/")
	public String goWelcome() {
		return "index";
	}
}
