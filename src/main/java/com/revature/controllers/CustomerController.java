package com.revature.controllers;

import com.revature.model.Customer;
import com.revature.model.CustomerRequest;
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

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> addCustomer (@RequestBody CustomerRequest cr){
        String name = cr.getName();
        String email = cr.getEmail();
        String password = cr.getPassword();

        Customer customer = cs.addCustomer(name, email, password);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // Considered using GET instead of POST because all it's functionality doing is retrieving the Customer
    // given an email and password. However, it wouldn't make sense to put that in the url for a login.
    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<Customer> loginCustomer(@RequestBody CustomerRequest cr){
        String email = cr.getEmail();
        String password = cr.getPassword();

        Customer customer = cs.loginCustomer(email, password);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping(value = "/close", consumes = "application/json")
    public ResponseEntity<Boolean> deleteCustomer(@RequestBody CustomerRequest cr){
        String email = cr.getEmail();
        String password = cr.getPassword();
        boolean wasDeleted = cs.deleteCustomer(email, password);
        return new ResponseEntity<>(wasDeleted, (wasDeleted) ? HttpStatus.NO_CONTENT : HttpStatus.UNPROCESSABLE_ENTITY);
    }



}
