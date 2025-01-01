package com.example.demo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class AuthenController {
	
	@GetMapping("/login")
	public String login() {
		return "dangnhap";
	}
	
	@GetMapping("/register")
	public String register() {
		return "dangki";
	}

}
