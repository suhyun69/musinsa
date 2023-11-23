package com.musinsa.suhpark.controller;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.dto.BrandByCategory;
import com.musinsa.suhpark.dto.LowestPriceBrand;
import com.musinsa.suhpark.dto.LowestPriceBrandByCategory;
import com.musinsa.suhpark.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/search/api")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/lowestPriceBrandByCategory")
    public ResponseEntity<LowestPriceBrandByCategory> getLowestPriceBrandByCategory() {

        LowestPriceBrandByCategory lowestPriceBrandByCategory = searchService.getLowestPriceBrandByCategory();

        return ResponseEntity.ok()
                .body(lowestPriceBrandByCategory);
    }

    @GetMapping("/lowestPriceBrand")
    public ResponseEntity<LowestPriceBrand> getLowestPriceBrand() {

        LowestPriceBrand lowestPriceBrand = searchService.getLowestPriceBrand();

        return ResponseEntity.ok()
                .body(lowestPriceBrand);
    }

    @GetMapping("/brandByCategory")
    public ResponseEntity<BrandByCategory> getBrandByCategory(@RequestParam CategoryType categoryType) {

        BrandByCategory brandByCategory = searchService.getHighestAndLowestBrandByCategory(categoryType);

        return ResponseEntity.ok()
                .body(brandByCategory);
    }
}
