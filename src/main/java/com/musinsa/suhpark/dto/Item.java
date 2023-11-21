package com.musinsa.suhpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Item {
    private String brand;
    private String category;
    private Integer price;

    public Item(com.musinsa.suhpark.domain.Item item) {
        this.brand = item.getBrand().getName();
        this.category = item.getCategoryType().name();
        this.price = item.getPrice();
    }
}
