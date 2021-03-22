package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.luv2code.springsecurity.demo.util.ViewNames;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return ViewNames.BOOTSTRAP_LOGIN;
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return ViewNames.ACCESS_DENIED;
	}
}
