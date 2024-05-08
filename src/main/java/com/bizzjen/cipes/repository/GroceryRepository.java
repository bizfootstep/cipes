package com.bizzjen.cipes.repository;

import com.bizzjen.cipes.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery, Long> {
}
