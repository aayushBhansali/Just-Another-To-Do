package com.project.todo.controllers;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.todo.models.Task;
import com.project.todo.repositories.TasksDao;
import com.project.todo.services.TaskServices;
import com.project.todo.services.UserService;

@Controller
@RequestMapping(path = "/todo")
public class TaskController {
	
	@Autowired
	TaskServices taskService;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping(path = "/loginSuccess")
	public String loginSuccess(HttpSession session) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		long userId = userService.getUserByUserName(username).getId();
		session.setAttribute("id", userId);
		return "redirect:/todo/show";
	}
	
	@RequestMapping(path = "/ajaxTest", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Task> sendAjax() {
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.addAll(taskService.getAllTasksByUserId(1));
		return tasks;
	}
	
	@GetMapping(path = "/pendingTasks", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Task> sendPendingTasks(HttpSession session) {
		long uid = (long) session.getAttribute("id");
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.addAll(taskService.getAllPendingTasksByUserId(uid));
		return tasks;
	}
	
	@GetMapping(path = "/todayTasks", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ArrayList<Task> sendTodayTasks(HttpSession session) {
		long uid = (long) session.getAttribute("id");
		ArrayList<Task> tasks = new ArrayList<>();
		tasks.addAll(taskService.getAllTodayTasksByUserId(uid));
		
		return tasks;
	}
	

	@GetMapping(path = "/show")
	public String showTodos(HttpSession session) {
		return "todo";
	}
	
	
	@PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean addTask(@RequestParam("title") String title, HttpSession session) {
		System.out.println("Heyyy");
		Task task = new Task();
		task.setDate(new Date(System.currentTimeMillis()));
		long userId = (long) session.getAttribute("id");
		task.setUserid(userId);
		task.setTask(title);
		task.setTime(new Time(System.currentTimeMillis()));
		taskService.addTask(task);
	
		return true;
	}
	
	
	@PostMapping(path = "/remove")
	@ResponseBody
	public boolean removeTask(@RequestParam("id") Long taskId) {
		taskService.removeTask(taskId);
		return true;
	}
	
	
}
