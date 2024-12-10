package com.bianca.todo.service.impl;

import com.bianca.todo.model.Guest;
import com.bianca.todo.repository.GuestRepository;
import com.bianca.todo.repository.TaskRepository;
import com.bianca.todo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getById(int id) {
        return guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found with ID: " + id));
    }

    @Override
    public Guest save(Guest guest) {
        if (guest.getFirstName() == null || guest.getLastName() == null || guest.getPhoneNumber() == null) {
            throw new RuntimeException("Guest must have a first name, last name, and phone number.");
        }

        // Ensure no duplicate guests (optional check)
        boolean exists = guestRepository.existsById(guest.getId());
        if (exists) {
            throw new RuntimeException("Guest with ID " + guest.getId() + " already exists.");
        }

        return guestRepository.save(guest);
    }

    @Override
    public Guest update(int id, Guest updatedGuest) {
        Guest existingGuest = guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found with ID: " + id));

        existingGuest.setFirstName(updatedGuest.getFirstName());
        existingGuest.setLastName(updatedGuest.getLastName());
        existingGuest.setPhoneNumber(updatedGuest.getPhoneNumber());

        return guestRepository.save(existingGuest);
    }

    @Override
    public void delete(int id) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Guest not found with ID: " + id));

        // Optional: Ensure guest has no associated tasks before deleting
        if (guest.getTasks() != null && !guest.getTasks().isEmpty()) {
            throw new RuntimeException("Cannot delete Guest with ID " + id + " as they have associated tasks.");
        }

        guestRepository.deleteById(id);
    }
}
