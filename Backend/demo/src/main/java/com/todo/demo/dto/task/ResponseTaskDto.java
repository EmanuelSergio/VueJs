package com.todo.demo.dto.task;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseTaskDto {
    @NotNull
    private Boolean status;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime startedDate;
    @NotNull
    private LocalDateTime finishedDate;
}
