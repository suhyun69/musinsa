package com.musinsa.suhpark.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
}
