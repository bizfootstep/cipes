package com.bizzjen.cipes.service;

import com.bizzjen.cipes.dto.GroceryCategoryRequestDto;
import com.bizzjen.cipes.dto.GroceryCategoryResponseDto;
import com.bizzjen.cipes.dto.GroceryRequestDto;
import com.bizzjen.cipes.dto.GroceryResponseDto;
import com.bizzjen.cipes.entity.Grocery;
import com.bizzjen.cipes.entity.GroceryCategory;
import com.bizzjen.cipes.exception.CipesClassNotFoundException;
import com.bizzjen.cipes.exception.ExceptionMessage;
import com.bizzjen.cipes.repository.GroceryCategoryRepository;
import com.bizzjen.cipes.repository.GroceryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroceryService {
    private final GroceryRepository groceryRepository;
    private final GroceryCategoryRepository groceryCategoryRepository;
    private final ModelMapper mapper;

    public GroceryService(GroceryRepository groceryRepository, GroceryCategoryRepository groceryCategoryRepository, ModelMapper mapper) {
        this.groceryRepository = groceryRepository;
        this.groceryCategoryRepository = groceryCategoryRepository;
        this.mapper = mapper;
    }

    public GroceryCategoryResponseDto createGroceryCategory(GroceryCategoryRequestDto requestDto) {
        Optional<GroceryCategory> categoryName = groceryCategoryRepository.findByCategoryName(requestDto.getCategoryName());
        if(categoryName.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, ExceptionMessage.DUPLICATE_FOUND.getDescription());
        }
        GroceryCategory groceryCategory = this.mapper.map(requestDto, GroceryCategory.class);
        return mapper.map(this.groceryCategoryRepository.save(groceryCategory), GroceryCategoryResponseDto.class);
    }

    public GroceryCategoryResponseDto getGroceryCategoryById(int categoryId) {
        Optional<GroceryCategory> groceryCategory = this.groceryCategoryRepository.findById(BigInteger.valueOf(categoryId));
        if (groceryCategory.isEmpty()) {
            throw new CipesClassNotFoundException(ExceptionMessage.NOT_FOUND.name());
        }
        return this.mapper.map(groceryCategory.get(), GroceryCategoryResponseDto.class);
    }

    public GroceryResponseDto createGrocery(GroceryRequestDto groceryRequestDto) {
        Grocery grocery = new Grocery();
        grocery.setGroceryName(groceryRequestDto.getGroceryName());
        Optional<GroceryCategory> category = this.groceryCategoryRepository.findById(BigInteger.valueOf(groceryRequestDto.getCategoryId()));
        if (category.isEmpty()) {
            throw new CipesClassNotFoundException(ExceptionMessage.NOT_FOUND.getDescription());
        }
        grocery.setCategory(category.get());
        return this.mapper.map(this.groceryRepository.save(grocery), GroceryResponseDto.class);
    }

    public GroceryResponseDto getGroceryById(long groceryId) {
        Optional<Grocery> grocery = this.groceryRepository.findById(groceryId);
        if (grocery.isEmpty()) {
            throw new CipesClassNotFoundException(ExceptionMessage.NOT_FOUND.name());
        }
        return this.mapper.map(grocery.get(), GroceryResponseDto.class);
    }

    public List<GroceryResponseDto> getAllGrocery() {
        List<Grocery> groceryList = this.groceryRepository.findAll();
        return groceryList.stream().map(grocery -> this.mapper.map(grocery, GroceryResponseDto.class))
                .collect(Collectors.toList());
    }

    public void deleteAllGrocery(){
        this.groceryRepository.deleteAll();
    }

    public List<GroceryCategoryResponseDto> getAllGroceryCategory() {
        List<GroceryCategory> groceryCategoryList = this.groceryCategoryRepository.findAll();
        return groceryCategoryList.stream().map(category -> this.mapper.map(category, GroceryCategoryResponseDto.class))
                .collect(Collectors.toList());
    }
}
