package com.todo.demo.services.view;

import com.todo.demo.entities.views.ViewPersonTask;
import com.todo.demo.repositories.view.ViewPersonTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ViewPersonTaskService {
    private final ViewPersonTaskRepository repository;

    public List<ViewPersonTask> getAllPersonTasks(){
        return this.repository.findAll();
    }
}
