package com.musinsa.suhpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LowestPriceBrandByCategoryDetail {
    private String 카테고리;
    private String 브랜드;
    private String 가격;

    public LowestPriceBrandByCategoryDetail(com.musinsa.suhpark.domain.Item item) {
        this.set카테고리(item.getCategoryType().name());
        this.set브랜드(item.getBrand().getName());
        this.set가격(new DecimalFormat("#,###").format(item.getPrice()));
    }
}
