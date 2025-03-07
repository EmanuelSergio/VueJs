package com.todo.demo.entities.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "view_person_task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewPersonTask {
    @Id
    @Column(name = "id")
    private Integer personId;
    @Column(name = "name")
    private String name;
    @Column(name = "title")
    private String title;
    @Column(name = "status")
    private Boolean status;
}
