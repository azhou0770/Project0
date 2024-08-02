package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo implements JpaRepository<Customer, Integer> {
    Customer findByEmailAndPassword(String email, String password);
}
