package com.bianca.todo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "TASKS")
public class Task {

    @Id
    @GenericGenerator(name = "id")
    @GeneratedValue(generator = "id")
    public int id;

    @Column(name = "title")
    public String title;

    @Column(name = "description")
    public String description;

    @Column(name = "status")
    public String status;  //  "Pending", "In Progress", "Completed"

    @Column(name = "due_date")
    private Date dueDate;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    @JsonIgnoreProperties("tasks")
    private Guest guest;

}

