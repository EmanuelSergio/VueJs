package com.todo.demo.dto.task;

import lombok.*;
import jakarta.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateTaskDto {
    @NotNull
    private String title;
    @NotNull
    private String description;
}
