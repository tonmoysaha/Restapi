package com.spring.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestHomeController {
	
	@RequestMapping("/")
	public String homePage() {
		return "index";
	}

}
