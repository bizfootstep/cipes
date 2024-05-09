package com.bizzjen.cipes.service;

import com.bizzjen.cipes.dto.GroceryCategoryResponseDto;
import com.bizzjen.cipes.dto.GroceryResponseDto;
import com.bizzjen.cipes.entity.Grocery;
import com.bizzjen.cipes.entity.GroceryCategory;
import com.bizzjen.cipes.repository.GroceryCategoryRepository;
import com.bizzjen.cipes.repository.GroceryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GroceryServiceTest {
    @Mock
    private GroceryRepository groceryRepository;

    @Mock
    private GroceryCategoryRepository groceryCategoryRepository;


    @Spy
    private ModelMapper mapper;

    @InjectMocks
    private GroceryService groceryService;

    @Test
    public void getAllGroceryTest() {
        GroceryCategory groceryCategory = new GroceryCategory(1, "Fruit");
        Grocery grocery1 = new Grocery(1, "Breakfast", groceryCategory, new HashSet<>());
        Grocery grocery2 = new Grocery(2, "Dinner", groceryCategory, new HashSet<>());
        List<Grocery> groceryList = new ArrayList<>();
        groceryList.add(grocery1);
        groceryList.add(grocery2);
        when(groceryRepository.findAll()).thenReturn(groceryList);

        List<GroceryResponseDto> actualAllGroceryList = groceryService.getAllGrocery();

        List<GroceryResponseDto> expectedAllGroceryList = new ArrayList<>();
        GroceryCategoryResponseDto fruit = new GroceryCategoryResponseDto(1, "Fruit");
        expectedAllGroceryList.add(new GroceryResponseDto(1, "Breakfast", fruit));
        expectedAllGroceryList.add(new GroceryResponseDto(2, "Dinner", fruit));

        assertEquals(expectedAllGroceryList, actualAllGroceryList);
    }
}
