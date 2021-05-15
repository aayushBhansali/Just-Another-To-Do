package com.project.todo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.todo.models.Task;

@Repository
public interface TasksDao extends JpaRepository<Task, Long>{
	
	@Query(value= "select * from task where userid = ?1 order by time desc", nativeQuery = true)
	public ArrayList<Task> findAllByUserId(long uid);
	
	@Query(value = "select * from task where userid = ?1 and not date = curdate() order by time desc", nativeQuery = true)
	public ArrayList<Task> findAllPendingByUserId (long uid);
	
	@Query(value = "select * from task where userid = ?1 and date = curdate() order by time desc", nativeQuery = true)
	public ArrayList<Task> findAllTodayByUserId (long uid);
}
