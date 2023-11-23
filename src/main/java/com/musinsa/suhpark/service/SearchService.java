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

        Comparator<Brand> comparator = (b1, b2) -> Integer.compare(itemRepository.findByBrand(b1).stream().mapToInt(b -> b.getPrice()).sum(), itemRepository.findByBrand(b2).stream().mapToInt(b -> b.getPrice()).sum());
        Brand lowestPriceBrand = brandRepository.findAll().stream()
                .min(comparator)
                .get();

        return new LowestPriceBrand(itemRepository.findByBrand(lowestPriceBrand));
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
