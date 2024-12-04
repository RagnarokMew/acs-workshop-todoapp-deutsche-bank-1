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

    @GetMapping("/task")
    public Task getById(@RequestParam Integer id) {
        return taskService.getById(id);
    }

    @GetMapping("/tasks")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping("/task")
    public Task updateTask(@RequestParam Integer id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/task")
    public void deleteById(@RequestParam Integer id) {
        taskService.delete(id);
    }
}
