package com.revature.services;

import com.revature.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerService {
    public Customer addCustomer(String name, String email, String password);
    public Customer loginCustomer(String email, String password);
    public boolean deleteCustomer(String email, String password);
}
