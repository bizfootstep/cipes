package com.bizzjen.cipes.dto;

import com.bizzjen.cipes.entity.GroceryCategory;
import lombok.Data;

@Data
public class GroceryResponseDto {
    private long groceryId;
    private GroceryCategory groceryName;
}
