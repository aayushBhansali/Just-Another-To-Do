package com.project.todo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.project.todo.models.User;
import com.project.todo.services.UserService;

@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path = "/")
	public String landing() {
		return "landing";
	}
	
	@GetMapping(path = "/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping(path = "/signup")
	public String showSignupPage(@ModelAttribute User user) {
		user = new User();
		return "signup";
	}
	
	@PostMapping(path = "/signup")
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
	
	@GetMapping(path = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		session.invalidate();
		return "landing";
	}
}
