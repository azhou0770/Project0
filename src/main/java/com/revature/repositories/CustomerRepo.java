package com.revature.repositories;

import com.revature.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Customer findByEmailAndPassword(String email, String password);
}
