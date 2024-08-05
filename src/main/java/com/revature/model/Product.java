package com.revature.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String description;

    @Column
    private String category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_fk")
    @JsonBackReference
    private Customer customer;
}
