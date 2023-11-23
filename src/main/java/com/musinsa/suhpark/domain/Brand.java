package com.musinsa.suhpark.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID", updatable = false)
    private Long brandId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Builder
    public Brand(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
