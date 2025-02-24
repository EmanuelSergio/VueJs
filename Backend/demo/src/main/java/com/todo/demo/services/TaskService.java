package com.todo.demo.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.demo.entities.Task;
import com.todo.demo.repositories.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public void create(Task task){
        repository.save(task);
    }

    public Task getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Task> getAll(){
        return repository.findAll();
    }

    public void update(Task task){
        repository.save(task);
    }
    public void delete(Integer id){
        Task task = repository.findById(id).orElse(null);
        if (task != null) {
            repository.deleteById(id);
        }
    }
    
}
