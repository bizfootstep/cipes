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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long groceryId;
    private String groceryName;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private GroceryCategory category;
    @ManyToMany(mappedBy = "groceries", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Recipe> recipes;
}
