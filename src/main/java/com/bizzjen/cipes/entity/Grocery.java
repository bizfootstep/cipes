package com.bizzjen.cipes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "GROCERY_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long groceryId;
    private String groceryName;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private GroceryCategory category;
    @ManyToMany(mappedBy = "groceries", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Recipe> recipes;
}
