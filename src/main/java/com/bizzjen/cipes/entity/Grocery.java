package com.bizzjen.cipes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Grocery {
    @Id
    @GeneratedValue
    private long groceryId;
    private String groceryName;
    @ManyToOne
    @Column(name="category_id")
    private GroceryCategory category;
}
