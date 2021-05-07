package com.project.todo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todo.models.Tasks;
import com.project.todo.repositories.TasksDao;

@Service
public class TaskServices {
	
	@Autowired
	TasksDao taskDao;
	
	public void addTask(Tasks task) {
		taskDao.save(task);
	}
	
	public void removeTask(long id) {
		taskDao.deleteById(id);
	}
	
	public List<Tasks> getAllTasksByUserId(long uid) {
		List<Tasks> tasks = new ArrayList<>();
		tasks.addAll(taskDao.findAllByUserId(uid));
		return tasks;
	}
}
