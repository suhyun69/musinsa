package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LowestPriceBrand {
    private String 브랜드;
    private List<LowestPriceBrandDetail> 카테고리;
    private String 총액;

    public LowestPriceBrand(List<Item> itemList) {
        this.set브랜드(itemList.get(0).getBrand().getName());
        this.set카테고리(itemList.stream().map(LowestPriceBrandDetail::new).collect(Collectors.toList()));
        this.set총액(new DecimalFormat("#,###").format(itemList.stream().mapToInt(i -> i.getPrice()).sum()));
    }
}
