package com.musinsa.suhpark.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoryType {
    상의("TOP"),
    아우터("OUTER"),
    바지("PANTS"),
    스니커즈("SNEAKERS"),
    가방("BAG"),
    모자("HAT"),
    양말("SOCKS"),
    액세서리("ACCESSORIES");

    private final String title;
}
