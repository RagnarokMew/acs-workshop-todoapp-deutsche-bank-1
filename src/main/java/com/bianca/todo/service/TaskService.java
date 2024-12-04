package com.bianca.todo.service;

import com.bianca.todo.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task getById(Integer id);
    Task save(Task task);
    Task update(Integer id, Task task);
    void delete(Integer id);
}
