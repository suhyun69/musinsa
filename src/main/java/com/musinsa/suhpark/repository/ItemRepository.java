package com.musinsa.suhpark.repository;

import com.musinsa.suhpark.domain.Brand;
import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByCategoryType(CategoryType categoryType);
    List<Item> findByBrand(Brand brand);
}
