package com.todo.demo.Controller.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.demo.dto.task.CreateTaskDto;
import com.todo.demo.dto.task.UpdateTaskDto;
import com.todo.demo.entities.task.Task;
import com.todo.demo.services.task.TaskService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Integer id) {
        return taskService.getById(id);
    }

    @PostMapping("")
    public void create(@Valid @RequestBody CreateTaskDto task) {
        taskService.create(task);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody @Valid UpdateTaskDto data) {
        taskService.update(id, data);
    }

    @PutMapping("/start/{id}")
    public void startTask(@PathVariable Integer id) {
        taskService.startTask(id);
    }

    @PutMapping("/finish/{id}")
    public void finishTask(@PathVariable Integer id) {
        taskService.finishTask(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        taskService.delete(id);
    }
}
