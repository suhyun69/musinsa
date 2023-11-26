package com.musinsa.suhpark.controller;

import com.musinsa.suhpark.domain.CategoryType;
import com.musinsa.suhpark.domain.Item;
import com.musinsa.suhpark.dto.*;
import com.musinsa.suhpark.exception.ErrorResponse;
import com.musinsa.suhpark.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Item API", description = "상품 API")
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/api/items")
    @Operation(summary = "전체 상품 조회")
    public ResponseEntity<List<ItemResponse>> findItem() {

        List<Item> itemList = itemService.findItems();
        List<ItemResponse> itemResponseList = itemList.stream().map(ItemResponse::new).toList();

        return ResponseEntity.ok()
                .body(itemResponseList);
    }

    @GetMapping("/api/item")
    @Operation(summary = "개별 상품 조회")
    public ResponseEntity<ItemResponse> findItem(@RequestParam Long itemNo) {

        Item item = itemService.findItem(itemNo);
        ItemResponse itemResponse = new ItemResponse(item);

        return ResponseEntity.ok()
                .body(itemResponse);
    }

    @PostMapping("/api/item")
    @Operation(summary = "상품 등록")
    public ResponseEntity<ItemResponse> addItem(@RequestParam String brand, @RequestParam CategoryType categoryType, @RequestParam Integer price) {

        Item item = itemService.addItem(brand, categoryType, price);
        ItemResponse itemResponse = new ItemResponse(item);

        return ResponseEntity.ok()
                .body(itemResponse);
    }

    @PutMapping("/api/item")
    @Operation(summary = "상품 수정")
    public ResponseEntity<ItemResponse> updateItem(@RequestParam Long itemNo, @RequestParam Integer price) {

        Item item = itemService.updateItem(itemNo, price);
        ItemResponse itemResponse = new ItemResponse(item);

        return ResponseEntity.ok()
                .body(itemResponse);
    }

    @DeleteMapping("/api/item")
    @Operation(summary = "상품 삭제")
    public ResponseEntity<Void> deleteItem(@RequestParam Long itemNo) {

        itemService.deleteItem(itemNo);

        return ResponseEntity.ok()
                .build();
    }
}
