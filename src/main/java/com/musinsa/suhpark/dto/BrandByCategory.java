package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandByCategory {

    private String 카테고리;
    private List<BrandByCategoryDetail> 최저가;
    private List<BrandByCategoryDetail> 최고가;

    public BrandByCategory(CategoryType categoryType, List<Item> itemList) {
        this.set카테고리(categoryType.name());
        this.set최저가(Arrays.asList(new BrandByCategoryDetail(itemList.stream().min(Comparator.comparing(Item::getPrice)).get())));
        this.set최고가(Arrays.asList(new BrandByCategoryDetail(itemList.stream().max(Comparator.comparing(Item::getPrice)).get())));
    }
}
