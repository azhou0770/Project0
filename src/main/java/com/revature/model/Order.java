package com.revature.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Order {
    @Id //makes this a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="o_id",updatable = false)
    private int id;

    @Column
    private Date date;

    @Column(name="customer_id", nullable = false, unique = true)
    private int customerId;

    @Column(name="product_ids", nullable = false)
    private List<Integer> productIDs;

    @Column(name="total_cost", nullable = false)
    private int totalCost;
}