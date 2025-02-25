package com.todo.demo.repositories.person;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.demo.entities.person.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
