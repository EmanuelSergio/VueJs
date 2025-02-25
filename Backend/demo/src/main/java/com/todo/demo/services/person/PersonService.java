package com.todo.demo.services.person;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.demo.dto.person.CreatePersonDto;
import com.todo.demo.dto.person.UpdatePersonDto;
import com.todo.demo.entities.person.Person;
import com.todo.demo.repositories.person.PersonRepository;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public void create(CreatePersonDto personDto) {
        Person person = new Person();
        modelMapper.map(personDto, person);
        this.repository.save(person);
    }

    public List<Person> getAll() {
        return this.repository.findAll();
    }

    public Person getById(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    public void update(Integer id, UpdatePersonDto personDto) {
        Person person = getById(id);
        modelMapper.map(personDto, person);
    }

    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }
}
