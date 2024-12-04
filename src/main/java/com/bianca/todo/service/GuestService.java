package com.bianca.todo.service;

import com.bianca.todo.model.Guest;
import com.bianca.todo.model.Task;
import com.bianca.todo.repository.GuestRepository;
import com.bianca.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {
    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(int id) {
        return guestRepository.findById(id).orElse(null);
    }

    public Guest save(Guest guest) {
        return guestRepository.save(guest);
    }

    public Guest update(int id, Guest updatedGuest) {
        Guest existingGuest = guestRepository.findById(id).orElse(null);
        if (existingGuest != null) {
            existingGuest.setFirstName(updatedGuest.getFirstName());
            existingGuest.setLastName(updatedGuest.getLastName());
            existingGuest.setPhoneNumber(updatedGuest.getPhoneNumber());
            return guestRepository.save(existingGuest);
        }
        return null;
    }

    public void delete(int id) {
        guestRepository.deleteById(id);
    }

//    // Get all tasks for a specific guest
//    public List<Task> findTasksByGuestId(int guestId) {
//        Guest guest = guestRepository.findById(guestId).orElse(null);
//        if (guest != null) {
//            return guest.getTasks();
//        }
//        return null;
//    }
}
