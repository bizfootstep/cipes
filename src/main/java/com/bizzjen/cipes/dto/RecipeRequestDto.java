package com.bizzjen.cipes.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RecipeRequestDto {
    private String recipeType;
    private String steps;
    private Set<Long> groceryIds;
}
