package com.todo.demo.Controller.view;

import com.todo.demo.entities.views.ViewPersonTask;
import com.todo.demo.services.view.ViewPersonTaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/view")
public class ViewPersonTaskController {

    public final ViewPersonTaskService service;

    @GetMapping("/all")
    public List<ViewPersonTask> getAll(){
        return this.service.getAllPersonTasks();
    }
}
