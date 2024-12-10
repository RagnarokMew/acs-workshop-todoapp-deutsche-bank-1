package com.bianca.todo.service.impl;

import com.bianca.todo.model.Guest;
import com.bianca.todo.model.Task;
import com.bianca.todo.repository.GuestRepository;
import com.bianca.todo.repository.TaskRepository;
import com.bianca.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    GuestRepository guestRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task getById(Integer id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
    }

    @Override
    public void delete(Integer id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Integer id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(existingTask);
    }

    @Override
    public Task save(Task task) {
        if (task.getGuest() == null || task.getGuest().getId() == 0) {
            throw new RuntimeException("Guest ID is required.");
        }

        // Cauta Guest-ul în baza de date
        Guest guest = guestRepository.findById(task.getGuest().getId())
                .orElseThrow(() -> new RuntimeException("Guest not found with ID: " + task.getGuest().getId()));

        // Asociaza guest-ul cu task-ul
        task.setGuest(guest);

        // Salvează task-ul
        return taskRepository.save(task);
    }

}
