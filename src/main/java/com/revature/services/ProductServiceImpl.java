package com.revature.services;

import com.revature.model.Customer;
import com.revature.model.Product;
import com.revature.repositories.CustomerRepo;
import com.revature.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    ProductRepo productRepo;
    CustomerRepo customerRepo;
    @Autowired
    ProductServiceImpl(ProductRepo productRepo, CustomerRepo customerRepo) {
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
    }
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    public Product removeProduct(int id) {
        Product deleted = productRepo.findById(id).get();
        productRepo.delete(deleted);
        return deleted;
    }

    public Product getProductByID(int id) {
        return productRepo.findById(id).get();
    }

    public Product updateProduct(Product change) {
        if(productRepo.findById(change.getId()).isPresent()) {
            return productRepo.save(change);
        } else {
            return null;
        }
    }
}
