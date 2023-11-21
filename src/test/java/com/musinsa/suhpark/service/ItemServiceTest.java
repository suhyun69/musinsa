package com.musinsa.suhpark.service;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.dto.BrandByCategory;
import com.musinsa.suhpark.dto.LowestPriceBrand;
import com.musinsa.suhpark.dto.LowestPriceBrandByCategory;
import com.musinsa.suhpark.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @DisplayName("카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API")
    @Test
    void GetLowestPriceBrandByCategoryTest() {

        LowestPriceBrandByCategory lowestPriceBrandByCategory = itemService.getLowestPriceBrandByCategory();

        assertThat(lowestPriceBrandByCategory.getTotalPrice()).isEqualTo(34100);
    }

    @DisplayName("단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API")
    @Test
    void GetLowestPriceBrandTest() {

        LowestPriceBrand lowestPriceBrand = itemService.getLowestPriceBrand();

        assertThat(lowestPriceBrand.getTotalPrice()).isEqualTo(36100);
    }

    @DisplayName("카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API")
    @Test
    void GetHighestAndLowestBrandByCategoryTest() {

        BrandByCategory brandByCategory = itemService.getHighestAndLowestBrandByCategory(CategoryType.TOP);

        assertThat(brandByCategory.getLowestPrice().get(0).getPrice() + brandByCategory.getHighestPrice().get(0).getPrice()).isEqualTo(21400);
    }

}