package com.project.todo.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes = com.project.todo.JustAnotherToDoApplication.class)
@AutoConfigureMockMvc(addFilters = false)
class AuthControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testLanding() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(view().name("landing"))
		.andExpect(status().isOk());
	}

	@Test
	void testShowLoginPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/login"))
		.andExpect(view().name("login"))
		.andExpect(status().isOk());
	}

	@Test
	void testShowSignupPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/signup"))
		.andExpect(view().name("signup"))
		.andExpect(status().isOk());
	}

	@Test
	void testSignupSuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/signup"))
		.andExpect(status().isFound())
		.andExpect(redirectedUrl("login"));
	}

	@Test
	void testLogout() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/logout"))
		.andExpect(view().name("landing"))
		.andExpect(status().isOk());
	}

}
