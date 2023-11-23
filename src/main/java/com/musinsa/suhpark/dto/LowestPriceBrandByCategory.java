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
public class LowestPriceBrandByCategory {
    private List<LowestPriceBrandByCategoryDetail> lowestPriceBrandByCategoryDetailList;
    private int totalPrice;

    public LowestPriceBrandByCategory(List<Item> itemList) {
        this.lowestPriceBrandByCategoryDetailList = itemList.stream().map(LowestPriceBrandByCategoryDetail::new).collect(Collectors.toList());
        this.totalPrice = itemList.stream().mapToInt(i -> i.getPrice()).sum();
    }
}
