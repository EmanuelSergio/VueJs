package com.todo.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.demo.entities.Task;

public interface TaskRepository extends JpaRepository<Task,Integer>{

}
