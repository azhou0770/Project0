package com.revature.services;

import com.revature.model.Product;
import com.revature.model.StoreOwner;
import com.revature.repositories.StoreOwnerRepo;
import com.revature.repositories.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    ProductRepo productRepo;
    StoreOwnerRepo storeOwnerRepo;
    @Autowired
    ProductServiceImpl(ProductRepo productRepo, StoreOwnerRepo storeOwnerRepo) {
        this.productRepo = productRepo;
        this.storeOwnerRepo = storeOwnerRepo;
    }
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    public Product saveProduct(int storeOwnerID, Product product) {
        StoreOwner storeOwner = storeOwnerRepo.findById(storeOwnerID).get();
        storeOwner.getProducts().add(product);
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
