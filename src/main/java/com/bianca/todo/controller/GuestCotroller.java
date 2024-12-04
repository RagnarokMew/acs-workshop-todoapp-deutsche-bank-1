package com.bianca.todo.controller;

import com.bianca.todo.model.Guest;
import com.bianca.todo.model.Task;
import com.bianca.todo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestCotroller {
    @Autowired
    private GuestService guestService;

    // Get all guests
    @GetMapping
    public List<Guest> findAllGuests() {
        return guestService.findAll();
    }

    // Get a guest by ID
    @GetMapping("/{id}")
    public Guest findGuestById(@PathVariable int id) {
        return guestService.findById(id);
    }

//    // Get all tasks for a specific guest
//    @GetMapping("/{id}/tasks")
//    public List<Task> findTasksForGuest(@PathVariable int id) {
//        return guestService.findTasksByGuestId(id);
//    }

    // Create a new guest
    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.save(guest);
    }

    // Update an existing guest
    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable int id, @RequestBody Guest updatedGuest) {
        return guestService.update(id, updatedGuest);
    }

    // Delete a guest
    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable int id) {
        guestService.delete(id);
    }
}
