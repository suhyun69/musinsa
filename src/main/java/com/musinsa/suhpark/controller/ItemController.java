package com.musinsa.suhpark.controller;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.dto.BrandByCategory;
import com.musinsa.suhpark.dto.LowestPriceBrand;
import com.musinsa.suhpark.dto.LowestPriceBrandByCategory;
import com.musinsa.suhpark.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/api/getLowestPriceBrandByCategory")
    public ResponseEntity<LowestPriceBrandByCategory> getLowestPriceBrandByCategory() {

        LowestPriceBrandByCategory lowestPriceBrandByCategory = itemService.getLowestPriceBrandByCategory();

        return ResponseEntity.ok()
                .body(lowestPriceBrandByCategory);
    }

    @GetMapping("/api/getLowestPriceBrand")
    public ResponseEntity<LowestPriceBrand> getLowestPriceBrand() {

        LowestPriceBrand lowestPriceBrand = itemService.getLowestPriceBrand();

        return ResponseEntity.ok()
                .body(lowestPriceBrand);
    }

    @GetMapping("/api/getBrandByCategory")
    public ResponseEntity<BrandByCategory> getBrandByCategory(@RequestParam CategoryType categoryType) {

        BrandByCategory brandByCategory = itemService.getHighestAndLowestBrandByCategory(categoryType);

        return ResponseEntity.ok()
                .body(brandByCategory);
    }
}
