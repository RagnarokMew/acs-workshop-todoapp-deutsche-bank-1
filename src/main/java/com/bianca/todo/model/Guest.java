package com.bianca.todo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "GUESTS")
public class Guest {


    @Id
    @GenericGenerator(name = "id")
    @GeneratedValue(generator = "id")
    public int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "guest")
    @JsonIgnoreProperties("guest")
    private List<Task> tasks;
}


