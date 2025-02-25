package com.todo.demo.entities.person;

import java.util.Date;

import com.todo.demo.entities.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tb_person")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "dateBirth")
    private Date dateBirth;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
