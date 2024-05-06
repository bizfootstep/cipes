package com.bizzjen.cipes.dto;

import com.bizzjen.cipes.entity.KitchenType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KitchenItemRequestDto {
    private String name;
    private long kitchenTypeId;
}
