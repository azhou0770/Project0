package com.revature.controllers;

import com.revature.model.Customer;
import com.revature.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    CustomerService cs;

    @Autowired
    CustomerController(CustomerService cs){
        this.cs = cs;
    }

    // /artist
    @PostMapping(value = "customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> addCustomer (@RequestBody Customer c){
        Customer customer = cs.addCustomer(c);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Considered using GET instead of POST because all it's functionality doing is retrieving the Customer
    // given an email and password. However, it wouldn't make sense to put that in the url for a login.
    // /artist?email=test@example.com&password=yourpassword
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> loginCustomer(@RequestBody Customer c) {
        Customer customer = cs.loginCustomer(c.getEmail(), c.getPassword());
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> deleteCustomer(@RequestBody Customer c){
        boolean wasDeleted = cs.deleteCustomer(c.getEmail(), c.getPassword());
        return new ResponseEntity<>(wasDeleted, (wasDeleted) ? HttpStatus.NO_CONTENT : HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
