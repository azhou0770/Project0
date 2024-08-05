package com.revature.services;

import com.revature.model.Customer;
import com.revature.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo cr;

    @Override
    public Customer addCustomer(String name, String email, String password){
        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setPassword(password);
        return cr.save(c);
    }

    @Override
    public Customer loginCustomer(String email, String password){
        return cr.findByEmailAndPassword(email, password);
    }

    @Override
    public boolean deleteCustomer(String email, String password){
        Customer customer = cr.findByEmailAndPassword(email, password);
        if (customer != null) {
            cr.delete(customer);
            return true;
        }
        return false;
    }
}
