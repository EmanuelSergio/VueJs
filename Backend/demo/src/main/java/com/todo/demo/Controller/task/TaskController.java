package com.todo.demo.Controller.task;

import java.util.List;

import com.todo.demo.dto.task.UpdateTaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.todo.demo.dto.task.CreateTaskDto;
import com.todo.demo.dto.task.ResponseTaskDto;
import com.todo.demo.services.task.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{personId}/all")
    public List<ResponseTaskDto> getAll(@PathVariable("personId") Integer personId) {
        return taskService.getAll(personId);
    }

    @GetMapping("/{personId}/{id}")
    public ResponseTaskDto getById(@PathVariable Integer personId,@PathVariable Integer id) {
        return taskService.getById(personId, id);
    }

    @PostMapping("/{personId}")
    public void create(@PathVariable Integer personId, @Valid @RequestBody CreateTaskDto task) {
        taskService.create(personId, task);
    }

    @PatchMapping("/{personId}/{id}")
    public void update(@PathVariable Integer personId,@PathVariable Integer id, @RequestBody @Valid UpdateTaskDto data) {
        taskService.update(personId, id, data);
    }

    @PutMapping("/start/{personId}/{id}")
    public void startTask(@PathVariable Integer personId, @PathVariable Integer id) {
        taskService.startTask(personId, id);
    }

    @PutMapping("/finish/{personId}/{id}")
    public void finishTask(@PathVariable Integer personId, @PathVariable Integer id) {
        taskService.finishTask(personId, id);
    }

    @DeleteMapping("/{personId}/{id}")
    public void delete(@PathVariable Integer personId, @PathVariable Integer id) {
        taskService.delete(personId, id);
    }
}
