package com.revature.services;

import com.revature.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getAllProducts();
    public Product saveProduct(int id, Product product);
    public Product removeProduct(int id);
    public Product getProductByID(int id);
    public Product updateProduct(Product product);
}