package com.todo.demo.dto.person;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdatePersonDto {
    private String name;
    private String email;
    private Date dateBirth;
}
