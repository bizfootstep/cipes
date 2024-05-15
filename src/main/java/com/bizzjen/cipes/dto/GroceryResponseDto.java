package com.bizzjen.cipes.dto;

import com.bizzjen.cipes.entity.Grocery;
import com.bizzjen.cipes.entity.GroceryCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryResponseDto {
    private long groceryId;
    private String groceryName;
    private GroceryCategoryResponseDto category;
}
