package com.todo.demo.Controller.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.demo.dto.person.CreatePersonDto;
import com.todo.demo.dto.person.UpdatePersonDto;
import com.todo.demo.entities.person.Person;
import com.todo.demo.services.person.PersonService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/all")
    public List<Person> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Integer id) {
        return this.service.getById(id);
    }

    @PostMapping()
    public void create(@RequestBody CreatePersonDto person) {
        this.service.create(person);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UpdatePersonDto person) {
        this.service.update(id, person);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        this.service.deleteById(id);
    }
}
