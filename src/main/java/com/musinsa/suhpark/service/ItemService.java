package com.musinsa.suhpark.service;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.domain.Category;
import com.musinsa.suhpark.repository.ItemRepository;
import com.musinsa.suhpark.repository.BrandRepository;
import com.musinsa.suhpark.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ItemRepository itemRepository;

    public List<Item> addBrandCategory() {

        // itemRepository.save(new Item(brand, category));

        return itemRepository.findAll();
    }
}
