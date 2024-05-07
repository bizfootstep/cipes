package com.bizzjen.cipes.repository;

import com.bizzjen.cipes.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface GroceryRepository extends JpaRepository<Grocery, BigDecimal> {
}
