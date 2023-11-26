package com.musinsa.suhpark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LowestPriceResponse {
    private LowestPriceBrand 최저가;

    public LowestPriceResponse(LowestPriceBrand lowestPriceBrand) {
        this.set최저가(lowestPriceBrand);
    }
}
