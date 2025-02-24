package com.todo.demo.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "startedDate")
    private Date startedDate;
    @Column(name = "finishedDate")
    private Date finishedDate;
}
