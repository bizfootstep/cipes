package com.bizzjen.cipes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue
    private long kitchenId;
    @Column(name = "kitchenType")
    private String kitchenTypeName;
}
