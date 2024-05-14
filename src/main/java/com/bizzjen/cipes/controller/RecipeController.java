package com.bizzjen.cipes.controller;

import com.bizzjen.cipes.dto.RecipeRequestDto;
import com.bizzjen.cipes.dto.RecipeResponseDto;
import com.bizzjen.cipes.response.ResponseDetail;
import com.bizzjen.cipes.response.ResponseHandler;
import com.bizzjen.cipes.response.ResponseMessage;
import com.bizzjen.cipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.management.ManagementFactory;
import java.util.List;

@RestController
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes")
    public ResponseEntity<ResponseDetail> getAllRecipes() {
        List<RecipeResponseDto> recipes = this.recipeService.getRecipes();
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, recipes);
    }

    @PostMapping("/recipe")
    public ResponseEntity<ResponseDetail> createRecipe(@RequestBody @Valid RecipeRequestDto requestDto){
        RecipeResponseDto recipe = this.recipeService.createRecipe(requestDto);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(), HttpStatus.OK, recipe);
    }

    @DeleteMapping("/recipe/{id}")
    public ResponseEntity<ResponseDetail> deleteRecipeById(@PathVariable long id){
        this.recipeService.deleteRecipeById(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(), HttpStatus.OK, null);
    }

    @PutMapping("/recipe/{id}/publish")
    public ResponseEntity<ResponseDetail> publishRecipeById(@PathVariable long id) {
        this.recipeService.publishRecipe(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(), HttpStatus.OK, null);
    }

    @GetMapping("/recipes/published")
    public ResponseEntity<ResponseDetail> getPublishedRecipes() {
        List<RecipeResponseDto> recipes = this.recipeService.getPublishedRecipeList();
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, recipes);
    }


    @PostMapping("/buyRecipe/{recipeId}")
    public ResponseEntity<ResponseDetail> buyRecipe(@PathVariable long recipeId){
//        Object object = recipeService.buyRecipe(recipeId);
        Object object = recipeService.buyRecipe(String.valueOf(recipeId));
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, object);
    }
}
