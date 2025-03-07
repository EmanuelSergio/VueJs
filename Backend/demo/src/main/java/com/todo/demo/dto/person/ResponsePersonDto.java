package com.todo.demo.dto.person;

import java.util.List;
import com.todo.demo.dto.task.ResponseTaskDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponsePersonDto {
    @NotNull
    private String name;
    @NotNull
    private List<ResponseTaskDto> tasks;
}
