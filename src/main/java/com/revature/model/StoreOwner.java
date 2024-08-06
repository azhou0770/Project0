package com.revature.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "storeowner")
public class StoreOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column()
    private String email;

    @Column()
    private String password;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "storeowner_fk")
    @JsonManagedReference
    private List<Product> products;

}
