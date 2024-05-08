package com.bizzjen.cipes.repository;

import com.bizzjen.cipes.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
