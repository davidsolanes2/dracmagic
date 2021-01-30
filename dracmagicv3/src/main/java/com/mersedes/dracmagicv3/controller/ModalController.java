package com.mersedes.dracmagicv3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mersedes.dracmagicv3.model.User;

@Controller
@RequestMapping("modals")
public class ModalController {

	@GetMapping("/login")
	public String login() {
		return "/layouts/modals/login";
	}
	
	@GetMapping("/register")
	public String register(User user) {
		return "/layouts/modals/register";
	}
	
}
