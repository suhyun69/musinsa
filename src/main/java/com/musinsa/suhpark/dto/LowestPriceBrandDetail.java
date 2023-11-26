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
public class LowestPriceBrandDetail {
    private String 카테고리;
    private String 가격;

    public LowestPriceBrandDetail(Item item) {
        this.set카테고리(item.getCategoryType().name());
        this.set가격(new DecimalFormat("#,###").format(item.getPrice()));
    }
}
