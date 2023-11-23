package com.musinsa.suhpark.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "BRAND_ID", nullable = false)
    private Brand brand;

    // @ManyToOne
    // @JoinColumn(name = "CATEGORY_ID", nullable = false)
    @Column(name = "CATEGORY_TYPE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CategoryType categoryType;

    @Column(name = "PRICE", nullable = false)
    private Integer price;

    public Item(Brand brand, CategoryType categoryType, Integer price) {
        this.brand = brand;
        this.categoryType = categoryType;
        this.price = price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
