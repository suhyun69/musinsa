package com.musinsa.suhpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddItemRequest {
    private String brand;
    private String category;
    private Integer price;
}
