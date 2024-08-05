package com.revature.services;

import com.revature.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    public Customer addCustomer(Customer c);
    public Customer loginCustomer(String email, String password);
    public boolean deleteCustomer(String email, String password);
}
