package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Category {
    private String category;
    private Integer price;

    public Category(Item item) {
        this.category = item.getCategoryType().name();
        this.price = item.getPrice();
    }
}
