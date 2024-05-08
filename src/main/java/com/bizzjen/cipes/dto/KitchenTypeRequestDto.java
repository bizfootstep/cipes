package com.bizzjen.cipes.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KitchenTypeRequestDto {
    @NotNull
    private String kitchenTypeName;
}
