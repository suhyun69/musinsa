package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LowestPriceBrand {
    private String brand;
    private List<Category> categoryList;
    private Integer totalPrice;

    public LowestPriceBrand(List<Item> itemList) {
        this.brand = itemList.get(0).getBrand().getName();
        this.categoryList = itemList.stream().map(Category::new).collect(Collectors.toList());
        this.totalPrice = itemList.stream().mapToInt(i -> i.getPrice()).sum();
    }
}
