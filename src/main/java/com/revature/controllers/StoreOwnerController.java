package com.revature.controllers;

import com.revature.model.Product;
import com.revature.model.StoreOwner;
import com.revature.services.StoreOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreOwnerController {
    StoreOwnerService sos;

    @Autowired
    StoreOwnerController(StoreOwnerService sos){
        this.sos = sos;
    }

    // /artist
    @PostMapping(value = "storeowner", consumes = "application/json", produces = "application/json")
    public ResponseEntity<StoreOwner> createStoreOwner (@RequestBody StoreOwner c){
        StoreOwner storeOwner = sos.createStoreOwner(c);
        return new ResponseEntity<>(storeOwner, HttpStatus.OK);
    }

    // Considered using GET instead of POST because all it's functionality doing is retrieving the Customer
    // given an email and password. However, it wouldn't make sense to put that in the url for a login.
    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<StoreOwner> loginStoreOwner(@RequestBody StoreOwner so) {
        StoreOwner storeOwner = sos.loginStoreOwner(so.getEmail(), so.getPassword());
        if (storeOwner != null) {
            return new ResponseEntity<>(storeOwner, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "storeowner", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> deleteStoreOwner(@RequestBody StoreOwner so){
        boolean wasDeleted = sos.deleteStoreOwner(so.getEmail(), so.getPassword());
        return new ResponseEntity<>(wasDeleted, (wasDeleted) ? HttpStatus.NO_CONTENT : HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @PostMapping(value = "/storeowner/products", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Product>> getProducts(@RequestBody StoreOwner so) {
        List<Product> products = sos.getProducts(so.getEmail(), so.getPassword());
        if (products != null){
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
