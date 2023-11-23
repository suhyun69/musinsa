package com.musinsa.suhpark.controller;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.dto.*;
import com.musinsa.suhpark.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/api/lowestPriceBrandByCategory")
    public ResponseEntity<LowestPriceBrandByCategory> getLowestPriceBrandByCategory() {

        LowestPriceBrandByCategory lowestPriceBrandByCategory = itemService.getLowestPriceBrandByCategory();

        return ResponseEntity.ok()
                .body(lowestPriceBrandByCategory);
    }

    @GetMapping("/api/lowestPriceBrand")
    public ResponseEntity<LowestPriceBrand> getLowestPriceBrand() {

        LowestPriceBrand lowestPriceBrand = itemService.getLowestPriceBrand();

        return ResponseEntity.ok()
                .body(lowestPriceBrand);
    }

    @GetMapping("/api/brandByCategory")
    public ResponseEntity<BrandByCategory> getBrandByCategory(@RequestParam CategoryType categoryType) {

        BrandByCategory brandByCategory = itemService.getHighestAndLowestBrandByCategory(categoryType);

        return ResponseEntity.ok()
                .body(brandByCategory);
    }

    @PostMapping("/api/brand")
    public ResponseEntity<Brand> addBrand(@RequestBody AddBrandRequest request) {

        Brand brand = itemService.addBrand(request);

        return ResponseEntity.ok()
                .body(brand);
    }

    @PostMapping("/api/item")
    public ResponseEntity<ItemResponse> addItem(@RequestParam String brand, @RequestParam CategoryType categoryType, @RequestParam Integer price) {

        Item item = itemService.addItem(brand, categoryType, price);
        ItemResponse itemResponse = new ItemResponse(item);

        return ResponseEntity.ok()
                .body(itemResponse);
    }
}
