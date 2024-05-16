package com.bizzjen.cipes.controller;

import com.bizzjen.cipes.dto.RecipeRequestDto;
import com.bizzjen.cipes.dto.RecipeResponseDto;
import com.bizzjen.cipes.response.ResponseDetail;
import com.bizzjen.cipes.response.ResponseHandler;
import com.bizzjen.cipes.response.ResponseMessage;
import com.bizzjen.cipes.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.management.ManagementFactory;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDetail> getAllRecipes(Pageable pageable) {
        List<RecipeResponseDto> recipes = this.recipeService.getRecipes(pageable);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, recipes);
    }

    @PostMapping
    public ResponseEntity<ResponseDetail> createRecipe(@RequestBody @Valid RecipeRequestDto requestDto){
        RecipeResponseDto recipe = this.recipeService.createRecipe(requestDto);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(), HttpStatus.OK, recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDetail> deleteRecipeById(@PathVariable long id){
        this.recipeService.deleteRecipeById(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(), HttpStatus.OK, null);
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity<ResponseDetail> publishRecipeById(@PathVariable long id) {
        this.recipeService.publishRecipe(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(), HttpStatus.OK, null);
    }

    @GetMapping("/all/published")
    public ResponseEntity<ResponseDetail> getPublishedRecipes() {
        List<RecipeResponseDto> recipes = this.recipeService.getPublishedRecipeList();
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(), HttpStatus.OK, recipes);
    }


    @PostMapping("/buy/{recipeId}")
    public ResponseEntity<ResponseDetail> buyRecipe(@PathVariable long recipeId){
//        Object object = recipeService.buyRecipe(recipeId);
        Object object = recipeService.buyRecipe(String.valueOf(recipeId));
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(), HttpStatus.OK, object);
    }

    @PostMapping("/publish/all")
    public ResponseEntity<ResponseDetail> publishAllRecipes(){
        recipeService.publishAllRecipe();
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(),HttpStatus.OK,null);
    }
}
