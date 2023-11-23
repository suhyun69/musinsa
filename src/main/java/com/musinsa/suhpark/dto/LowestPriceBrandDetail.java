package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LowestPriceBrandDetail {
    private String category;
    private Integer price;

    public LowestPriceBrandDetail(Item item) {
        this.category = item.getCategoryType().name();
        this.price = item.getPrice();
    }
}
