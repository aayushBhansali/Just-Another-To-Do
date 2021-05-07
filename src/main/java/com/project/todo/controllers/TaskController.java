package com.project.todo.controllers;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.todo.models.Tasks;
import com.project.todo.repositories.TasksDao;
import com.project.todo.services.TaskServices;
import com.project.todo.services.UserService;

@Controller
public class TaskController {
	
	@Autowired
	TaskServices taskService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(path = "/todo/loginSuccess", method = RequestMethod.GET)
	public String loginSuccess(HttpSession session) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		long userId = userService.getUserByUserName(username).getId();
		session.setAttribute("id", userId);
		System.out.println("Success");
		return "redirect:/todo/show";
	}
	

	@SuppressWarnings("deprecation")
	@RequestMapping(path = "/todo/show", method = RequestMethod.GET)
	public String showTodos(@ModelAttribute("pendingTasks") ArrayList<Tasks> pendingTasks,
							@ModelAttribute("todaysTasks") ArrayList<Tasks> todaysTasks,
							HttpSession session) {
		
		long uid = (long) session.getAttribute("id");
		
		ArrayList<Tasks> tasks = new ArrayList<>();
		tasks.addAll(taskService.getAllTasksByUserId(uid));
		
//		Fetch today's day of the month
		Date date = new Date(System.currentTimeMillis());
		int today = Integer.parseInt(date.toString().substring(0, 2)); 
				
//		For each task, if it was added today, add it to today's tasks
//					   else add it to pending tasks
		for(Tasks task: tasks) {
			int check = Integer.parseInt(task.getDate().toString().substring(0, 2));
			if(check == today)
				todaysTasks.add(task);
			else
				pendingTasks.add(task);
		}
		
		return "todo";
	}
	
	@RequestMapping(path = "/todo/add", method = RequestMethod.POST)
	public String addTask(@RequestParam("title") String title, HttpSession session) {
		Tasks task = new Tasks();
		task.setDate(new Date(System.currentTimeMillis()));
		long userId = (long) session.getAttribute("id");
		task.setUserid(userId);
		task.setTask(title);
		task.setTime(new Time(System.currentTimeMillis()));
;		taskService.addTask(task);
		
		System.out.println("Added task");
		return "redirect:/todo/show";
	}
	
	@RequestMapping(path = "/todo/remove", method = RequestMethod.POST)
	public String removeTask(@RequestParam("id") Long taskId) {
		taskService.removeTask(taskId);
		System.out.println("Removing");
		return "redirect:/todo/show";
	}
	
	
}
