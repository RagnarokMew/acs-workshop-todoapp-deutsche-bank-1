package com.bianca.todo.service;

import com.bianca.todo.model.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> findAll();
    Guest getById(int id);
    Guest save(Guest guest);
    Guest update(int id, Guest updatedGuest);
    void delete(int id);
}
