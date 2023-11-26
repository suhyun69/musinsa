package com.musinsa.suhpark.service;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.dto.AddBrandRequest;
import com.musinsa.suhpark.repository.BrandRepository;
import com.musinsa.suhpark.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    BrandRepository brandRepository;

    public List<Brand> findBrands() {
        return brandRepository.findAll();
    }

    public Brand findBrand(Long brandNo) {
        Brand brand = brandRepository.findById(brandNo)
                .orElseThrow(() -> new IllegalArgumentException(String.format("브랜드를 찾을 수 없습니다 - brandNo : %d", brandNo)));

        return brand;
    }

    public Brand addBrand(AddBrandRequest request) {

        try {
            brandRepository.findByName(request.getBrand())
                    .orElseThrow(() ->  new IllegalArgumentException(String.format("이미 등록된 브랜드입니다.")));

            return brandRepository.save(request.toEntity());
        }
        catch(Exception ex) {
            throw new RuntimeException("브랜드 등록에 실패했습니다.");
        }
    }

    public Brand updateBrand(Long brandNo, String name) {

        try {
            Brand brand = brandRepository.findById(brandNo)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("브랜드를 찾을 수 없습니다 - brandNo : %d", brandNo)));
            brand.setName(name);

            return brandRepository.save(brand);
        }
        catch(Exception ex) {
            throw new RuntimeException("브랜드 수정에 실패했습니다.");
        }
    }

    @Transactional
    public void deleteBrand(Long brandNo) {

        try {
            Brand brand = brandRepository.findById(brandNo)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("브랜드를 찾을 수 없습니다 - brandNo : %d", brandNo)));

            itemRepository.findByBrand(brand).stream().forEach(i -> itemRepository.delete(i));
            brandRepository.deleteById(brandNo);
        }
        catch(Exception ex) {
            throw new RuntimeException("브랜드 삭제에 실패했습니다.");
        }
    }
}
