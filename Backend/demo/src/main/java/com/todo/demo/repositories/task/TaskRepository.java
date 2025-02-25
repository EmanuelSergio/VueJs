package com.todo.demo.repositories.task;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.demo.entities.task.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
