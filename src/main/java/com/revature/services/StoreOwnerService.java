package com.revature.services;

import com.revature.model.StoreOwner;
import org.springframework.stereotype.Service;

@Service
public interface StoreOwnerService {
    public StoreOwner createStoreOwner(StoreOwner c);
    public StoreOwner loginStoreOwner(String email, String password);
    public boolean deleteStoreOwner(String email, String password);
}
