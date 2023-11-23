package com.musinsa.suhpark.service;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.dto.*;
import com.musinsa.suhpark.repository.ItemRepository;
import com.musinsa.suhpark.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ItemRepository itemRepository;

    public Item findItem(Long itemNo) {
        Item item = itemRepository.findById(itemNo)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + itemNo));

        return item;
    }

    public Item addItem(String brandName, CategoryType categoryType, Integer price) {

        Brand brand = brandRepository.findByName(brandName)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + brandName));

        return itemRepository.save(new Item(brand, categoryType, price));
    }

    public Item updateItem(Long itemNo, Integer price) {

        Item item = itemRepository.findById(itemNo)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + itemNo));
        item.setPrice(price);

        return itemRepository.save(item);
    }

    public void deleteItem(Long itemNo) {
        itemRepository.deleteById(itemNo);
    }
}
