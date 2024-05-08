package com.bizzjen.cipes.dto;

import lombok.Data;

import java.util.Set;

@Data
public class RecipeResponseDto {
    private long recipeId;
    private String recipeType;
    private String steps;
    private Set<GroceryResponseDto> groceries;
}
