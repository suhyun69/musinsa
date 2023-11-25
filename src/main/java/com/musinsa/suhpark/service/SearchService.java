package com.musinsa.suhpark.service;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.dto.BrandByCategory;
import com.musinsa.suhpark.dto.LowestPriceBrand;
import com.musinsa.suhpark.dto.LowestPriceBrandByCategory;
import com.musinsa.suhpark.repository.BrandRepository;
import com.musinsa.suhpark.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ItemRepository itemRepository;

    public LowestPriceBrandByCategory getLowestPriceBrandByCategory() {

        List<Item> itemList = Arrays.stream(CategoryType.values())
                .map(type -> itemRepository.findByCategoryType(type).stream()
                        .min(Comparator.comparing(Item::getPrice))
                        .get())
                .collect(Collectors.toList());

        return new LowestPriceBrandByCategory(itemList);
    }

    public LowestPriceBrand getLowestPriceBrand() {

        // 8개 카테고리 상품을 모두 가지고 있는 브랜드 조회
        List<Brand> fullyCategoryItemBrand = brandRepository.findAll().stream()
                .filter(b -> itemRepository.findByBrand(b).stream().map(Item::getCategoryType).distinct().toList().size() == 8)
                .collect(Collectors.toList());

        Comparator<Brand> comparator = (b1, b2) -> Integer.compare(findItemByBrandWithLowestPrice(b1).stream().mapToInt(Item::getPrice).sum(), findItemByBrandWithLowestPrice(b2).stream().mapToInt(Item::getPrice).sum());
        Brand lowestPriceBrand = fullyCategoryItemBrand.stream()
                .min(comparator)
                .get();

        return new LowestPriceBrand(itemRepository.findByBrand(lowestPriceBrand));
    }

    private List<Item> findItemByBrandWithLowestPrice(Brand brand) {

        List<Item> itemList = itemRepository.findByBrand(brand);

        // 임의의 카테고리에 2개 이상의 상품을 가진 브랜드인 경우, 최저가 상품을 계산에 포함
        Arrays.stream(CategoryType.values())
                .forEach(c -> {
                    List<Item> itemListByCategory = itemList.stream()
                            .filter(i -> i.getCategoryType() == c)
                            .sorted(Comparator.comparing(Item::getPrice))
                            .collect(Collectors.toList());
                    itemList.add(itemListByCategory.get(0));
                });

        return itemList;
    }

    public BrandByCategory getHighestAndLowestBrandByCategory(CategoryType categoryType) {

        List<Item> itemList = new ArrayList<>();

        itemList.add(itemRepository.findByCategoryType(categoryType).stream()
                .min(Comparator.comparing(Item::getPrice))
                .get());

        itemList.add(itemRepository.findByCategoryType(categoryType).stream()
                .max(Comparator.comparing(Item::getPrice))
                .get());

        return new BrandByCategory(categoryType, itemList);
    }
}
