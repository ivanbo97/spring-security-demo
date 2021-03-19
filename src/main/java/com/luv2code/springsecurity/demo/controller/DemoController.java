package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.luv2code.springsecurity.demo.util.ViewNames;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showHome() {
		
		return ViewNames.HOME;
	}
}
