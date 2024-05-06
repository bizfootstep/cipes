package com.bizzjen.cipes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class KitchenItem {
    @Id
    @GeneratedValue
    private long kitchenItemId;
    @Column(name = "name")
    private String kitchenName;
    @ManyToOne
    @JoinColumn
    private KitchenType kitchenType;

}
