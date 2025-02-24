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

    public List<Task> create(Task task){
        System.out.println(task.getTitle());
        repository.save(task);
        return getAll();
    }

    public Task getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public List<Task> getAll(){
        return repository.findAll();
    }

    public List<Task> update(Task task){
        repository.save(task);
        return getAll();
    }
    public Task delete(Integer id){
        Task task = repository.findById(id).orElse(null);
        if (task != null) {
            repository.deleteById(id);
        }
        return task;
    }
}
