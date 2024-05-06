package com.bizzjen.cipes.dto;

import com.bizzjen.cipes.entity.KitchenType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KitchenItemResponseDto {
    private long kitchenItemId;
    private String kitchenName;
    private KitchenType kitchenType;
}
