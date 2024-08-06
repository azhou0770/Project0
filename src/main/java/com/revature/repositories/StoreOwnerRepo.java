package com.revature.repositories;

import com.revature.model.StoreOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreOwnerRepo extends JpaRepository<StoreOwner, Integer> {
    StoreOwner findByEmailAndPassword(String email, String password);
}
