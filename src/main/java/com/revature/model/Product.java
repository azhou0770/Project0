package com.revature.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Product {
    @Id //makes this a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id", updatable = false)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column
    private String description;

    @Column
    private String category;
}
