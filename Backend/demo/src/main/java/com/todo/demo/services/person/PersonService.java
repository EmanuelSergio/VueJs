package com.todo.demo.services.person;

import java.util.List;

import com.todo.demo.dto.person.PersonDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.demo.dto.person.CreatePersonDto;
import com.todo.demo.dto.person.ResponsePersonDto;
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

    public List<ResponsePersonDto> getAll() {
        List<Person> persons = this.repository.findAll();
        return modelMapper.map(persons, new TypeToken<List<ResponsePersonDto>>() {
        }.getType());
    }
    public <T> T getById(Integer id, Class<T> tClass){
        Person person = this.repository.findById(id).orElse(null);
        return modelMapper.map(person, tClass);
    }

    public ResponsePersonDto update(Integer id, UpdatePersonDto personDto) {
        Person person = this.repository.findById(id).orElse(null);
        if (person != null){
            modelMapper.map(personDto, person);
            this.repository.save(person);
            return modelMapper.map(person, ResponsePersonDto.class);
        }else {
            throw new RuntimeException("Usuario não encontrado!");
        }

    }

    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }
}
