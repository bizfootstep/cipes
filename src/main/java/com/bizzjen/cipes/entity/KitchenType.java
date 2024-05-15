package com.bizzjen.cipes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
// TODO: 03/05/2024 is the following constructor necessary?
//@NoArgsConstructor
//@AllArgsConstructor
public class KitchenType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long kitchenId;
    @Column(name = "kitchenType")
    private String kitchenTypeName;
}
