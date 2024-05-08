package com.bizzjen.cipes.repository;

import com.bizzjen.cipes.entity.GroceryCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface GroceryCategoryRepository extends JpaRepository<GroceryCategory, BigInteger> {

    Optional<GroceryCategory> findByCategoryName(String name);
}
