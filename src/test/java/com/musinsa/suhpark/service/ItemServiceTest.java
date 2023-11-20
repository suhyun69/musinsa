package com.musinsa.suhpark.service;

import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ItemServiceTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemService itemService;

    @DisplayName("generateToken(): 유저 정보와 만료 기간을 전달해 토큰을 만들 수 있다.")
    @Test
    void addTest() {

        List<Item> itemList = itemService.addBrandCategory();

        assertThat(itemList.size()).isEqualTo(72);
    }

}