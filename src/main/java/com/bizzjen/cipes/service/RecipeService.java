package com.bizzjen.cipes.service;

import com.bizzjen.cipes.dto.RecipeRequestDto;
import com.bizzjen.cipes.dto.RecipeResponseDto;
import com.bizzjen.cipes.entity.Grocery;
import com.bizzjen.cipes.entity.Recipe;
import com.bizzjen.cipes.exception.CipesClassNotFoundException;
import com.bizzjen.cipes.repository.GroceryRepository;
import com.bizzjen.cipes.repository.RecipeRepository;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final GroceryRepository groceryRepository;
    private final ModelMapper modelMapper;

    @Value("${payment.service.url}")
    private String paymentServiceUrl;

    @Autowired
    private RestTemplate restTemplate;
    public RecipeService(RecipeRepository recipeRepository, GroceryRepository groceryRepository, ModelMapper modelMapper) {
        this.recipeRepository = recipeRepository;
        this.groceryRepository = groceryRepository;
        this.modelMapper = modelMapper;
    }

    public RecipeResponseDto createRecipe(RecipeRequestDto requestDto) {
        Recipe recipe = new Recipe();
        recipe.setRecipeType(requestDto.getRecipeType());
        recipe.setSteps(requestDto.getSteps());
        List<Grocery> groceryList = this.groceryRepository.findAllById(requestDto.getGroceryIds());
        recipe.setGroceries(new HashSet<>(groceryList));
        Recipe savedRecipe = this.recipeRepository.save(recipe);
        return this.modelMapper.map(savedRecipe, RecipeResponseDto.class);
    }

    public List<RecipeResponseDto> getRecipes(Pageable pageable) {
//        List<Recipe> recipeList = this.recipeRepository.findAll();
        Page<Recipe> pageRecipeList = this.recipeRepository.findAll(pageable);
        return getRecipeResponseList(pageRecipeList.getContent());
    }

    public void deleteRecipeById(long id) {
        this.recipeRepository.deleteById(id);
    }

    public Recipe getRecipeEntityById(long id) {
        return recipeRepository.findById(id).orElseThrow(() -> new CipesClassNotFoundException("Recipe not found!"));
    }
    public void publishRecipe(long id) {
        Recipe recipe = getRecipeEntityById(id);
        recipe.setPublished(1);
        recipeRepository.save(recipe);
    }

    public List<RecipeResponseDto> getPublishedRecipeList() {
        List<Recipe> publishedRecipeList = recipeRepository.findByPublished(1);
        return getRecipeResponseList(publishedRecipeList);
    }



    private static List<RecipeResponseDto> getRecipeResponseList(List<Recipe> recipeList) {
        ModelMapper mapper = new ModelMapper();
        Converter<Integer, Boolean> statusConverter = new AbstractConverter<Integer, Boolean>() {
            @Override
            protected Boolean convert(Integer source) {
                return (source != null && source == 1) ? Boolean.TRUE : Boolean.FALSE;
            }
        };
        mapper.addConverter(statusConverter);
        mapper.typeMap(Recipe.class, RecipeResponseDto.class)
                .addMapping(Recipe::getPublished, RecipeResponseDto::setPublished);

        return recipeList.stream().map(recipe -> mapper.map(recipe, RecipeResponseDto.class))
                .collect(Collectors.toList());
    }

//    public Object buyRecipe(long recipeId) {
//        // URL of the payment service endpoint
//        String paymentServiceUrl = "http://localhost:8081/buyRecipe";
////        String paymentServiceUrl = "http://CIPES-PAYMENT-SERVICE/buyRecipe";
//
//        // Create a request entity with the recipeId
//        HttpEntity<Long> requestEntity = new HttpEntity<>(recipeId);
//
//        // Make an HTTP POST request to the payment service
//        ResponseEntity<Object> responseEntity = restTemplate.exchange(
//                paymentServiceUrl,
//                HttpMethod.POST,
//                requestEntity,
//                Object.class);
//
//        // Check the response and handle accordingly
//        if (responseEntity.getStatusCode().is2xxSuccessful()) {
//            // Payment successful
//            System.out.println("Recipe purchased successfully.");
//            return responseEntity.getBody();
//        }
//        return null;
//    }

    public String buyRecipe(String orderId){
        return restTemplate.getForObject(paymentServiceUrl + "/payment/order/status/" + orderId, String.class);
    }
}

