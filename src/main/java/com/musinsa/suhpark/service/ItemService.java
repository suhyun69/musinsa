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
                .orElseThrow(() -> new IllegalArgumentException(String.format("상품을 찾을 수 없습니다 - itemNo : %d", itemNo)));

        return item;
    }

    public Item addItem(String brandName, CategoryType categoryType, Integer price) {

        try {
            Brand brand = brandRepository.findByName(brandName)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("브랜드를 찾을 수 없습니다 - brandName : %s", brandName)));

            return itemRepository.save(new Item(brand, categoryType, price));
        }
        catch(Exception ex) {
            throw new RuntimeException("상품 추가에 실패했습니다.");
        }
    }

    public Item updateItem(Long itemNo, Integer price) {

        try {
            Item item = itemRepository.findById(itemNo)
                    .orElseThrow(() -> new IllegalArgumentException(String.format("상품을 찾을 수 없습니다 - itemNo : %d", itemNo)));
            item.setPrice(price);

            return itemRepository.save(item);
        }
        catch (Exception ex) {
            throw new RuntimeException("상품 수정에 실패했습니다.");
        }
    }

    public void deleteItem(Long itemNo) {
        try {
            itemRepository.deleteById(itemNo);
        }
        catch (Exception ex) {
            throw new RuntimeException("상품 삭제에 실패했습니다.");
        }
    }
}
