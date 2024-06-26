package com.bizzjen.cipes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name = "RECIPE_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recipeId;
    private String recipeType;
    private String steps;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int published;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "RECIPE_GROCERY_TABLE",
            joinColumns = {
                    @JoinColumn(name = "recipe_id", referencedColumnName = "recipeId")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "grocery_id", referencedColumnName = "groceryId")
            })
    private Set<Grocery> groceries;
}
