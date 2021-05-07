package com.project.todo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.project.todo.models.User;
import com.project.todo.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String landing() {
		System.out.println("Request received");
		return "landing";
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(path = "/signup", method = RequestMethod.GET)
	public String showSignupPage(@ModelAttribute User user) {
		user = new User();
		return "signup";
	}
	
	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public String signupSuccess(User user, Model model) {
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			user.setRole("USER");
			userService.addUser(user);
		}
		catch (Exception e) {
			model.addAttribute("error", "User already exists");
		}
		
		return "redirect:login";
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		session.invalidate();
		return "landing";
	}
}
