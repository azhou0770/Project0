package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;

public interface CustomerService {
    public Customer createCustomer(String username, String password);
    public Customer getCustomer(String username, String password);
    public boolean deleteCustomer(String username, String password);
}
