package com.bizzjen.cipes.repository;

import com.bizzjen.cipes.entity.KitchenType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface KitchenTypeRepository extends JpaRepository<KitchenType, BigDecimal> {
}
