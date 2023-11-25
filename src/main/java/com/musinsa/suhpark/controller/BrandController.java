package com.musinsa.suhpark.controller;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.dto.AddBrandRequest;
import com.musinsa.suhpark.exception.ErrorResponse;
import com.musinsa.suhpark.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/api/brand")
    public ResponseEntity<Brand> addBrand(@RequestParam Long brandNo) {

        Brand brand = brandService.findBrand(brandNo);

        return ResponseEntity.ok()
                .body(brand);
    }

    @PostMapping("/api/brand")
    public ResponseEntity<Brand> addBrand(@RequestBody AddBrandRequest request) {

        Brand brand = brandService.addBrand(request);

        return ResponseEntity.ok()
                .body(brand);
    }

    @PutMapping("/api/brand")
    public ResponseEntity<Brand> updateBrand(@RequestParam Long brandNo, @RequestParam String name) {

        Brand brand = brandService.updateBrand(brandNo, name);

        return ResponseEntity.ok()
                .body(brand);
    }

    @DeleteMapping ("/api/brand")
    public ResponseEntity<Brand> deleteBrand(@RequestParam Long brandNo) {

        brandService.deleteBrand(brandNo);

        return ResponseEntity.ok()
                .build();
    }
}
