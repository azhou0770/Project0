package com.revature.services;

import com.revature.model.Customer;
import com.revature.model.Product;
import com.revature.repositories.CustomerRepo;
import com.revature.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
