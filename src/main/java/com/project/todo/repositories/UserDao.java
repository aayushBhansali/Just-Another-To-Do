package com.project.todo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.todo.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	User findByUsername (String username);
}
