package com.todo.demo.services.task;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.todo.demo.dto.task.CreateTaskDto;
import com.todo.demo.dto.task.UpdateTaskDto;
import com.todo.demo.entities.task.Task;
import com.todo.demo.repositories.task.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public void create(CreateTaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setFinishedDate(null);
        task.setStartedDate(null);
        task.setStatus(null);
        this.repository.save(task);
    }

    public Task getById(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    public List<Task> getAll() {
        return this.repository.findAll();
    }

    public void update(Integer id, UpdateTaskDto taskDto) {
        Task task = getById(id);
        if (task != null) {
            modelMapper.map(taskDto, task);
            this.repository.save(task);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public void delete(Integer id) {
        Task task = getById(id);
        if (task != null) {
            this.repository.deleteById(id);
        }
    }

    public void startTask(Integer id) {
        Task task = getById(id);
        if (task != null) {
            if (task.getFinishedDate() == null) {
                task.setStartedDate(LocalDateTime.now());
                task.setStatus(true);
                UpdateTaskDto dto = new UpdateTaskDto();
                BeanUtils.copyProperties(task, dto);
                update(id, dto);
            }
        }
    }

    public void finishTask(Integer id) {
        Task task = getById(id);
        if (task != null) {
            if (task.getStartedDate() != null) {
                task.setFinishedDate(LocalDateTime.now());
                task.setStatus(false);
                UpdateTaskDto dto = new UpdateTaskDto();
                BeanUtils.copyProperties(task, dto);
                update(id, dto);
            }
        }
    }
}
