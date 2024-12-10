package com.bianca.todo.controller;

import com.bianca.todo.model.Guest;
import com.bianca.todo.model.Task;
import com.bianca.todo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;


    @GetMapping
    public List<Guest> findAllGuests() {
        return guestService.findAll();
    }


    @GetMapping("/{id}")
    public Guest findGuestById(@PathVariable int id) {
        return guestService.getById(id);
    }
/*
    // Get all tasks for a specific guest
    @GetMapping("/{id}/tasks")
    public List<Task> findTasksForGuest(@PathVariable int id) {
        return guestService.findTasksByGuestId(id);
    }

 */


    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return guestService.save(guest);
    }


    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable int id, @RequestBody Guest updatedGuest) {
        return guestService.update(id, updatedGuest);
    }


    @DeleteMapping("/{id}")
    public void deleteGuest(@PathVariable int id) {
        guestService.delete(id);
    }
}
