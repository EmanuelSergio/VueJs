package com.todo.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.demo.entities.Task;
import com.todo.demo.services.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<Task> getAll(){
        return taskService.getAll();
    }
    @GetMapping("/{id}")
    public Task getById(@PathVariable Integer id){
        return taskService.getById(id);
    }

    @PostMapping("")
    public List<Task> create(@RequestBody Task task) {
        System.out.println("batewu");
        return taskService.create(task);
    }
    
    @PutMapping("")
    public List<Task> update(@RequestBody Task task) {      
        return taskService.update(task);
    }

    @DeleteMapping("/{id}")
    public Task delete(@PathVariable Integer id){
        return taskService.delete(id);
    }
}
