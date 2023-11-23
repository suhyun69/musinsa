package com.musinsa.suhpark.service;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.dto.AddBrandRequest;
import com.musinsa.suhpark.repository.BrandRepository;
import com.musinsa.suhpark.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public Brand findBrand(Long brandNo) {
        Brand brand = brandRepository.findById(brandNo)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + brandNo));

        return brand;
    }

    public Brand addBrand(AddBrandRequest request) {
        return brandRepository.save(request.toEntity());
    }

    public Brand updateBrand(Long brandNo, String name) {

        Brand brand = brandRepository.findById(brandNo)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + brandNo));
        brand.setName(name);

        return brandRepository.save(brand);
    }

    public void deleteBrand(Long brandNo) {
        brandRepository.deleteById(brandNo);
    }
}
