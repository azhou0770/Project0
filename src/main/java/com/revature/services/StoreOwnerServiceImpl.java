package com.revature.services;

import com.revature.model.Product;
import com.revature.model.StoreOwner;
import com.revature.repositories.StoreOwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreOwnerServiceImpl implements StoreOwnerService {

    @Autowired
    StoreOwnerRepo sor;

    @Override
    public StoreOwner createStoreOwner(StoreOwner so){
        return sor.save(so);
    }

    @Override
    public StoreOwner loginStoreOwner(String email, String password){
        return sor.findByEmailAndPassword(email, password);
    }

    @Override
    public boolean deleteStoreOwner(String email, String password){
        StoreOwner storeOwner = sor.findByEmailAndPassword(email, password);
        if (storeOwner != null) {
            sor.delete(storeOwner);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getProducts(String email, String password){
        StoreOwner storeOwner = sor.findByEmailAndPassword(email, password);
        if (storeOwner != null){
            return storeOwner.getProducts();
        } else{
            return null;
        }
    }
}
