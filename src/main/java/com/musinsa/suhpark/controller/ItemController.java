package com.musinsa.suhpark.controller;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.dto.*;
import com.musinsa.suhpark.exception.ErrorResponse;
import com.musinsa.suhpark.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/api/item")
    public ResponseEntity<ItemResponse> findItem(@RequestParam Long itemNo) {

        Item item = itemService.findItem(itemNo);
        ItemResponse itemResponse = new ItemResponse(item);

        return ResponseEntity.ok()
                .body(itemResponse);
    }

    @PostMapping("/api/item")
    public ResponseEntity<ItemResponse> addItem(@RequestParam String brand, @RequestParam CategoryType categoryType, @RequestParam Integer price) {

        Item item = itemService.addItem(brand, categoryType, price);
        ItemResponse itemResponse = new ItemResponse(item);

        return ResponseEntity.ok()
                .body(itemResponse);
    }

    @PutMapping("/api/item")
    public ResponseEntity<ItemResponse> updateItem(@RequestParam Long itemNo, @RequestParam Integer price) {

        Item item = itemService.updateItem(itemNo, price);
        ItemResponse itemResponse = new ItemResponse(item);

        return ResponseEntity.ok()
                .body(itemResponse);
    }

    @DeleteMapping("/api/item")
    public ResponseEntity<Void> deleteItem(@RequestParam Long itemNo) {

        itemService.deleteItem(itemNo);

        return ResponseEntity.ok()
                .build();
    }
}
