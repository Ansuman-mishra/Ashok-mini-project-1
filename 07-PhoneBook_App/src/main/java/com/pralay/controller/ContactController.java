package com.pralay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pralay.entity.Contact;

@Controller
public class ContactController {
	
	@GetMapping("/loadForm")
	public String loadForm(Model model) {
		
		model.addAttribute("contact",new Contact());
		
		return "index";
	}
}
