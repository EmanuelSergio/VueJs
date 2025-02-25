package com.todo.demo.dto.task;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateTaskDto {
    private Boolean status;
    private String title;
    private String description;
    private LocalDateTime startedDate;
    private LocalDateTime finishedDate;
}
