package com.bizzjen.cipes.repository;

import com.bizzjen.cipes.entity.GroceryCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface GroceryCategoryRepository extends JpaRepository<GroceryCategory, BigInteger> {
}
