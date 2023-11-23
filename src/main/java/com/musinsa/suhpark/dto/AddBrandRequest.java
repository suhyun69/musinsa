package com.musinsa.suhpark.dto;

import com.musinsa.suhpark.domain.Brand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddBrandRequest {
    private String brand;

    public Brand toEntity() {
        return Brand.builder()
                .name(brand)
                .build();
    }
}
