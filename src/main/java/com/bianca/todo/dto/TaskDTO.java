package com.bianca.todo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Setter
@Getter
public class TaskDTO {
    private int id;
    private String title;
    private String description;
    private String status;
    private Date dueDate;

    // Getters and Setters
}