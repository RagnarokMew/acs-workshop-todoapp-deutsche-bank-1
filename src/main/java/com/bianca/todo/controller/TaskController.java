package com.bianca.todo.controller;

import com.bianca.todo.model.Task;
import com.bianca.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/task/{id}")
    public Task getById(@PathVariable Integer id) {
        return taskService.getById(id);
    }

    @GetMapping("/tasks")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping("/task")
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/task/{id}")
    public Task updateTask(@PathVariable Integer id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/task/{id}")
    public void deleteById(@PathVariable Integer id) {
        taskService.delete(id);
    }
}
