package com.todo.demo.repositories.view;

import com.todo.demo.entities.views.ViewPersonTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewPersonTaskRepository extends JpaRepository<ViewPersonTask, Integer> {
}
