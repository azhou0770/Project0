package com.revature.services;

import com.revature.repositories.CustomerRepo;
import com.revature.repositories.CustomerRepository;
import org.hibernate.annotations.DialectOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerRepo cr;

    @Override
    public Customer createCustomer(String email, String password){
        Customer customer = new Customer(email, password);
        return cr.save(customer);
    }

    @Override
    public Customer getCustomer(String email, String password){
        return cr.findByEmailAndPassword(email, password)
    }

    @Override
    public boolean deleteCustomer(String email, String password){
        Customer customer = cr.findByEmailAndPassword(email, password);
        if (customer != null) {
            customerRepository.delete(customer);
            return true;
        }
        return false;
    }
}
