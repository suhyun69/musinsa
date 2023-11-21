package com.musinsa.suhpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LowestPriceBrandByCategory {
    private List<Item> itemList;
    private int totalPrice;

    public LowestPriceBrandByCategory(List<com.musinsa.suhpark.domain.Item> itemList) {
        this.itemList = itemList.stream().map(Item::new).collect(Collectors.toList());
        this.totalPrice = itemList.stream().mapToInt(i -> i.getPrice()).sum();
    }
}
