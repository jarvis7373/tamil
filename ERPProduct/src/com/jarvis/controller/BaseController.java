package com.jarvis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Tamilselvan T Date 28-12-18
 *
 */

@Controller
@RequestMapping("/")
public class BaseController {

	@Autowired
	MessageSource message;
	
	@RequestMapping("login")
	public String login(){
		
		return "";
	}

}
