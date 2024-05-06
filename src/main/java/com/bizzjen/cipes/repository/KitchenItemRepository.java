package com.bizzjen.cipes.repository;

import com.bizzjen.cipes.entity.KitchenItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface KitchenItemRepository extends JpaRepository<KitchenItem, BigDecimal> {
}
