package com.revature.services;

import com.revature.model.Product;
import com.revature.model.StoreOwner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StoreOwnerService {
    public StoreOwner createStoreOwner(StoreOwner so);
    public StoreOwner loginStoreOwner(String email, String password);
    public boolean deleteStoreOwner(String email, String password);

    public List<Product> getProducts(String email, String password);
}
