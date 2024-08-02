package com.revature.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id //makes this a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_id",updatable = false)
    private int id;

    @Column
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
}
