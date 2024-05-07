package com.bizzjen.cipes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class GroceryCategory {

    @Id
    @GeneratedValue
    private int categoryId;

    private String categoryName;

}