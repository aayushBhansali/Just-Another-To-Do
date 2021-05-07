package com.project.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.todo.models.User;
import com.project.todo.repositories.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	public void addUser (User user) {
		userDao.save(user);
	}
	
	public User getUserById (Long id) {
		return userDao.findById(id).get();
	}
	
	public User getUserByUserName (String username) {
		return userDao.findByUsername(username);
	}
}
