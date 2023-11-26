package com.musinsa.suhpark.controller;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.dto.BrandByCategory;
import com.musinsa.suhpark.dto.LowestPriceBrand;
import com.musinsa.suhpark.dto.LowestPriceBrandByCategory;
import com.musinsa.suhpark.dto.LowestPriceResponse;
import com.musinsa.suhpark.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "최저가 상품 검색 API", description = "브랜드 및 카테고리 별 최저가 조회")
@RequiredArgsConstructor
@RestController
@RequestMapping("/search/api")
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/lowestPriceBrandByCategory")
    @Operation(summary = "1. 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API")
    public ResponseEntity<LowestPriceBrandByCategory> getLowestPriceBrandByCategory() {

        LowestPriceBrandByCategory lowestPriceBrandByCategory = searchService.getLowestPriceBrandByCategory();

        return ResponseEntity.ok()
                .body(lowestPriceBrandByCategory);
    }

    @GetMapping("/lowestPriceBrand")
    @Operation(summary = "2. 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API")
    public ResponseEntity<LowestPriceResponse> getLowestPriceBrand() {

        LowestPriceBrand lowestPriceBrand = searchService.getLowestPriceBrand();
        LowestPriceResponse lowestPriceResponse = new LowestPriceResponse(lowestPriceBrand);

        return ResponseEntity.ok()
                .body(lowestPriceResponse);
    }

    @GetMapping("/brandByCategory")
    @Operation(summary = "3. 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API")
    public ResponseEntity<BrandByCategory> getBrandByCategory(@RequestParam CategoryType categoryType) {

        BrandByCategory brandByCategory = searchService.getHighestAndLowestBrandByCategory(categoryType);

        return ResponseEntity.ok()
                .body(brandByCategory);
    }
}
