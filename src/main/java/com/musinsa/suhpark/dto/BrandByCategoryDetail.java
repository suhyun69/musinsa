package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BrandByCategoryDetail {
    private String 브랜드;
    private String 가격;

    public BrandByCategoryDetail(Item item) {
        this.set브랜드(item.getBrand().getName());
        this.set가격(new DecimalFormat("#,###").format(item.getPrice()));
    }
}
