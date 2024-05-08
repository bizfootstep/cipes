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
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        GroceryCategory groceryCategory = this.mapper.map(requestDto, GroceryCategory.class);
        return mapper.map(this.groceryCategoryRepository.save(groceryCategory), GroceryCategoryResponseDto.class);
    }

    public GroceryCategoryResponseDto getGroceryCategoryById(int categoryId) {
        Optional<GroceryCategory> groceryCategory = this.groceryCategoryRepository.findById(BigInteger.valueOf(categoryId));
        if(groceryCategory.isEmpty()){
            throw new CipesClassNotFoundException(ExceptionMessage.NOT_FOUND.name());
        }
        return this.mapper.map(groceryCategory.get(), GroceryCategoryResponseDto.class);
    }

    public GroceryResponseDto createGrocery(GroceryRequestDto groceryRequestDto){
        Grocery grocery = this.mapper.map(groceryRequestDto, Grocery.class);
        return this.mapper.map(this.groceryRepository.save(grocery), GroceryResponseDto.class);
    }

    public GroceryResponseDto getGroceryById(long groceryId){
        Optional<Grocery> grocery = this.groceryRepository.findById(groceryId);
        if(grocery.isEmpty()){
            throw new CipesClassNotFoundException(ExceptionMessage.NOT_FOUND.name());
        }
        return this.mapper.map(grocery.get(), GroceryResponseDto.class);
    }

    public List<GroceryResponseDto> getAllGrocery(){
        List<Grocery> groceryList = this.groceryRepository.findAll();
        List<GroceryResponseDto> groceryResponseList = new ArrayList<>();
        groceryList.forEach(grocery -> {
            groceryResponseList.add(this.mapper.map(grocery, GroceryResponseDto.class));
        });
        return groceryResponseList;
    }

}
