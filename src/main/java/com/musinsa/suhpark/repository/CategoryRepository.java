package com.musinsa.suhpark.repository;

import com.musinsa.suhpark.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
