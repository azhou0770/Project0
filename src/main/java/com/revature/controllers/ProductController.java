package com.revature.controllers;

import com.revature.model.Product;
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
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("product")
    public Product postProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }


    @DeleteMapping("product/{id}")
    public Product deleteProduct(@PathVariable int id) {
        return productService.removeProduct(id);
    }

    @GetMapping("product/{id}")
    public Product getProductByID(@PathVariable int id) {
        return productService.getProductByID(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,
                                                 @PathVariable int id) {
        product.setId(id);
        Product changed = productService.updateProduct(product);

        if(changed != null) {
            return new ResponseEntity<>(changed,
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
