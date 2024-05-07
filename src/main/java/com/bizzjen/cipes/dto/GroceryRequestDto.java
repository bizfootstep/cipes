package com.bizzjen.cipes.dto;

import lombok.Data;

import java.util.Map;

@Data
public class GroceryRequestDto {
    private String groceryName;
    private int categoryId;
}
