package com.bianca.todo.dto;

import com.bianca.todo.model.Task;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Setter
@Getter
public class GuestDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<TaskDTO> tasks;

    // Getters and Setters
}