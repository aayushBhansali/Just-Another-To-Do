package com.project.todo.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.todo.models.Tasks;

@Repository
public interface TasksDao extends JpaRepository<Tasks, Long>{
	
	@Query(value= "select * from tasks where userid = ?1 order by time desc", nativeQuery = true)
	public ArrayList<Tasks> findAllByUserId(long uid);
}
