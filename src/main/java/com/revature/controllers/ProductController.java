package com.revature.controllers;

import com.revature.model.Product;
import com.revature.model.StoreOwner;
import com.revature.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("product")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        if (allProducts != null) {
            return new ResponseEntity<>(allProducts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("product/{id}")
    public ResponseEntity<Product> postProduct(@PathVariable int id, @RequestBody Product product) {
        Product product1 = productService.saveProduct(id, product);
        if (product1 != null) {
            return new ResponseEntity<>(product1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


    @DeleteMapping("product/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int id) {
        Product product = productService.removeProduct(id);
        if (product != null) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductByID(@PathVariable int id) {
        Product product = productService.getProductByID(id);
        if(product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,
                                                 @PathVariable int id) {
        product.setId(id);
        Product changed = productService.updateProduct(product);

        if(changed != null) {
            return new ResponseEntity<>(changed, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
