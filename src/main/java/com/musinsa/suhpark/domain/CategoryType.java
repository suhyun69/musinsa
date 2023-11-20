package com.musinsa.suhpark.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CategoryType {
    TOP("T"),
    OUTER("O"),
    PANTS("P"),
    SNEAKERS("S"),
    BAG("B"),
    HAT("H"),
    SOCKS("C"),
    ACCESSORIES("A");

    private final String code;
}
