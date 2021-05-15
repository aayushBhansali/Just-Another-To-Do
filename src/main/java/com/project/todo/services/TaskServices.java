package com.project.todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todo.models.Task;
import com.project.todo.repositories.TasksDao;

@Service
public class TaskServices {
	
	@Autowired
	TasksDao taskDao;
	
	public void addTask(Task task) {
		taskDao.save(task);
	}
	
	public void removeTask(long id) {
		taskDao.deleteById(id);
	}
	
	public List<Task> getAllTasksByUserId(long uid) {
		List<Task> tasks = new ArrayList<>();
		tasks.addAll(taskDao.findAllByUserId(uid));
		return tasks;
	}
	
	public List<Task> getAllPendingTasksByUserId (long uid) {
		List<Task> tasks = new ArrayList<>();
		tasks.addAll(taskDao.findAllPendingByUserId(uid));
		return tasks;
	}
	
	public List<Task> getAllTodayTasksByUserId (long uid) {
		List<Task> tasks = new ArrayList<>();
		tasks.addAll(taskDao.findAllTodayByUserId(uid));
		return tasks;
	}
}
