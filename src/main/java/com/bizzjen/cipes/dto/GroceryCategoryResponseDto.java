package com.bizzjen.cipes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroceryCategoryResponseDto {
    private int categoryId;
    private String categoryName;
}
