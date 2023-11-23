package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BrandByCategory {

    private String category;
    private List<BrandByCategoryDetail> lowestPrice;
    private List<BrandByCategoryDetail> highestPrice;

    public BrandByCategory(CategoryType categoryType, List<Item> itemList) {
        this.category = categoryType.name();
        this.lowestPrice = Arrays.asList(new BrandByCategoryDetail(itemList.stream().min(Comparator.comparing(Item::getPrice)).get()));
        this.highestPrice = Arrays.asList(new BrandByCategoryDetail(itemList.stream().max(Comparator.comparing(Item::getPrice)).get()));
    }
}
