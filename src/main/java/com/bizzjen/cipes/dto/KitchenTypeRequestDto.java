package com.bizzjen.cipes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KitchenTypeRequestDto {
    @NotNull
    private String kitchenTypeName;
}
