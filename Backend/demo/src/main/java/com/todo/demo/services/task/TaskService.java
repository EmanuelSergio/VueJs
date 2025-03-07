package com.todo.demo.services.task;

import java.time.LocalDateTime;
import java.util.List;

import com.todo.demo.dto.person.CreatePersonDto;
import com.todo.demo.dto.person.PersonDto;
import com.todo.demo.repositories.person.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.todo.demo.dto.person.ResponsePersonDto;
import com.todo.demo.dto.task.CreateTaskDto;
import com.todo.demo.dto.task.ResponseTaskDto;
import com.todo.demo.dto.task.UpdateTaskDto;
import com.todo.demo.entities.person.Person;
import com.todo.demo.entities.task.Task;
import com.todo.demo.repositories.task.TaskRepository;
import com.todo.demo.services.person.PersonService;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository repository;
    private final PersonService personService;
    private final ModelMapper modelMapper;

    public void create(Integer personId, CreateTaskDto taskDto) {
        PersonDto person = personService.getById(personId, PersonDto.class);
        System.out.println(person);
        if (person!= null){
            Task task = new Task();
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setFinishedDate(null);
            task.setStartedDate(null);
            task.setStatus(null);
            task.setPerson(modelMapper.map(person,Person.class));
            this.repository.save(task);
        }
    }

    public ResponseTaskDto getById(Integer personId, Integer id) {
        Person person = personService.getById(personId, Person.class);
        List<Task> tasks = person.getTasks();
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
        if (task != null){
            return modelMapper.map(task, ResponseTaskDto.class);
        }else {
            throw new RuntimeException("Tarefa não encontrada!");
        }
    }

    public List<ResponseTaskDto> getAll(Integer personId) {
        Person person = personService.getById(personId, Person.class);
        List<Task> tasks = person.getTasks();
        return modelMapper.map(tasks, new TypeToken<List<ResponseTaskDto>>() {
        }.getType());
    }

    public ResponseTaskDto update(Integer personId, Integer id, UpdateTaskDto taskDto) {
        Person person = personService.getById(personId, Person.class);
        List<Task> tasks = person.getTasks();
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
        if (task != null) {
            modelMapper.map(taskDto, task);
            this.repository.save(task);

            return modelMapper.map(task,ResponseTaskDto.class);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public void delete(Integer personId, Integer id) {
        Person person = personService.getById(personId, Person.class);
        List<Task> tasks = person.getTasks();
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
        if (task != null) {
            this.repository.deleteById(id);
        }
    }

    public void startTask(Integer personId, Integer id) {
        Person person = personService.getById(personId, Person.class);
        List<Task> tasks = person.getTasks();
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
        if (task != null) {
            UpdateTaskDto taskDto = modelMapper.map(task, UpdateTaskDto.class);
            if (taskDto.getFinishedDate() == null) {
                taskDto.setStartedDate(LocalDateTime.now());
                taskDto.setStatus(true);
                update(personId, id, taskDto);
            }
        }
    }

    public void finishTask(Integer personId, Integer id) {
        Person person = personService.getById(personId, Person.class);
        List<Task> tasks = person.getTasks();
        Task task = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
        if (task != null) {
            UpdateTaskDto taskDto = modelMapper.map(task, UpdateTaskDto.class);
            if (taskDto.getStartedDate() != null) {
                taskDto.setFinishedDate(LocalDateTime.now());
                taskDto.setStatus(false);
                update(personId, id, taskDto);
            }
        }
    }
}
