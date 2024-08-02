package com.revature.services;

import com.revature.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerService {
    public Customer addCustomer(Customer c);
    public Customer getCustomer(int id);
    public boolean deleteCustomer(int id);
}
