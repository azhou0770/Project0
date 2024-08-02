package com.revature.services;

import com.revature.model.Customer;
import com.revature.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerRepo cr;

    public Customer addCustomer(Customer c) {
        return cr.save(c);
    }

    public Customer getCustomer(String email, String password){
        return cr.findByEmailAndPassword(email, password);
    }

    public boolean deleteCustomer(String email, String password){
        Customer customer = cr.findByEmailAndPassword(email, password);
        if (customer != null) {
            cr.delete(customer);
            return true;
        }
        return false;
    }
}
