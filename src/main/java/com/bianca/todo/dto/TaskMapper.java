package com.bianca.todo.dto;

import com.bianca.todo.model.Task;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toTaskDTO(Task task);

    Task toTaskEntity(TaskDTO taskDTO);
}