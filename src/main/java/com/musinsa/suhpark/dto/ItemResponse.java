package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ItemResponse {
    private Long itemNo;
    private String brand;
    private String category;
    private Integer price;

    public ItemResponse(Item item) {
        this.itemNo = item.getItemId();
        this.brand = item.getBrand().getName();
        this.category = item.getCategoryType().getTitle();
        this.price = item.getPrice();
    }
}
