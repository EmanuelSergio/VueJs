package com.todo.demo.dto.person;

import java.util.Date;
import com.todo.demo.entities.user.User;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePersonDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Date dateBirth;
    // @NotNull
    // private User user;
}
