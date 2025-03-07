package com.todo.demo.entities.task;

import java.time.LocalDateTime;

import com.todo.demo.entities.person.Person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "startedDate")
    private LocalDateTime startedDate;
    @Column(name = "finishedDate")
    private LocalDateTime finishedDate;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
