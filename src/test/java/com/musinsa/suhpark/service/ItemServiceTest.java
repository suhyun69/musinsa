package com.musinsa.suhpark.service;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
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

    @DisplayName("generateToken(): 유저 정보와 만료 기간을 전달해 토큰을 만들 수 있다.")
    @Test
    void addTest() {

        List<Item> itemList = itemService.addBrandCategory();

        assertThat(itemList.size()).isEqualTo(72);
    }

    @DisplayName("카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회하는 API")
    @Test
    void GetLowestPriceBrandByCategoryTest() {

        List<Item> itemList = itemService.getLowestPriceBrandByCategory();

        assertThat(itemList.stream().mapToInt(i -> i.getPrice()).sum()).isEqualTo(34100);
    }

    @DisplayName("단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API")
    @Test
    void GetLowestPriceBrandTest() {

        List<Item> itemList = itemService.getLowestPriceBrand();

        assertThat(itemList.stream().mapToInt(i -> i.getPrice()).sum()).isEqualTo(36100);
    }

    @DisplayName("카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API")
    @Test
    void GetHighestAndLowestBrandByCategoryTest() {

        List<Item> itemList = itemService.getHighestAndLowestBrandByCategory(CategoryType.TOP);

        assertThat(itemList.stream().mapToInt(i -> i.getPrice()).sum()).isEqualTo(21400);
    }

}