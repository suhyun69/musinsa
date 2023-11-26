package com.musinsa.suhpark.controller;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.dto.AddBrandRequest;
import com.musinsa.suhpark.exception.ErrorResponse;
import com.musinsa.suhpark.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Brand API", description = "브랜드 API")
@RequiredArgsConstructor
@RestController
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/api/brands")
    @Operation(summary = "전체 브랜드 조회")
    public ResponseEntity<List<Brand>> findBrands() {

        List<Brand> brandList = brandService.findBrands();

        return ResponseEntity.ok()
                .body(brandList);
    }

    @GetMapping("/api/brand")
    @Operation(summary = "개별 브랜드 조회")
    public ResponseEntity<Brand> findBrand(@RequestParam Long brandNo) {

        Brand brand = brandService.findBrand(brandNo);

        return ResponseEntity.ok()
                .body(brand);
    }

    @PostMapping("/api/brand")
    @Operation(summary = "브랜드 등록")
    public ResponseEntity<Brand> addBrand(@RequestBody AddBrandRequest request) {

        Brand brand = brandService.addBrand(request);

        return ResponseEntity.ok()
                .body(brand);
    }

    @PutMapping("/api/brand")
    @Operation(summary = "브랜드 수정")
    public ResponseEntity<Brand> updateBrand(@RequestParam Long brandNo, @RequestParam String name) {

        Brand brand = brandService.updateBrand(brandNo, name);

        return ResponseEntity.ok()
                .body(brand);
    }

    @DeleteMapping ("/api/brand")
    @Operation(summary = "브랜드 삭제")
    public ResponseEntity<Brand> deleteBrand(@RequestParam Long brandNo) {

        brandService.deleteBrand(brandNo);

        return ResponseEntity.ok()
                .build();
    }
}
