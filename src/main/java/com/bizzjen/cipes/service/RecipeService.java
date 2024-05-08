package com.bizzjen.cipes.service;

import com.bizzjen.cipes.dto.RecipeRequestDto;
import com.bizzjen.cipes.dto.RecipeResponseDto;
import com.bizzjen.cipes.entity.Grocery;
import com.bizzjen.cipes.entity.Recipe;
import com.bizzjen.cipes.repository.GroceryRepository;
import com.bizzjen.cipes.repository.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final GroceryRepository groceryRepository;
    private final ModelMapper modelMapper;

    public RecipeService(RecipeRepository recipeRepository, GroceryRepository groceryRepository, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.groceryRepository = groceryRepository;
        this.modelMapper = modelMapper;
    }

    public RecipeResponseDto createRecipe(RecipeRequestDto requestDto){
        Recipe recipe = new Recipe();
        recipe.setRecipeType(requestDto.getRecipeType());
        recipe.setSteps(requestDto.getSteps());
        List<Grocery> groceryList = this.groceryRepository.findAllById(requestDto.getGroceryIds());
        recipe.setGroceries(new HashSet<>(groceryList));
        Recipe savedRecipe = this.recipeRepository.save(recipe);
        return this.modelMapper.map(savedRecipe, RecipeResponseDto.class);
    }

    public List<RecipeResponseDto> getRecipes() {
        List<Recipe> recipeList = this.recipeRepository.findAll();
        List<RecipeResponseDto> recipeResponseDtoList = new ArrayList<>();
        recipeList.forEach(recipe -> {
            recipeResponseDtoList.add(this.modelMapper.map(recipe,RecipeResponseDto.class));
        });
        return recipeResponseDtoList;
    }
}

