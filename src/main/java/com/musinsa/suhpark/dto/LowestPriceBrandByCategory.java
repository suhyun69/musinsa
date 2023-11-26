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
public class LowestPriceBrandByCategory {

    private List<LowestPriceBrandByCategoryDetail> 상품목록;
    private String 총액;

    public LowestPriceBrandByCategory(List<Item> itemList) {
        this.set상품목록(itemList.stream().map(LowestPriceBrandByCategoryDetail::new).collect(Collectors.toList()));
        this.set총액(new DecimalFormat("#,###").format(itemList.stream().mapToInt(i -> i.getPrice()).sum()));
    }
}
