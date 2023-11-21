package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Brand {
    private String brand;
    private Integer price;

    public Brand(Item item) {
        this.brand = item.getBrand().getName();
        this.price = item.getPrice();
    }
}
