package com.bizzjen.cipes.controller;

import com.bizzjen.cipes.dto.KitchenItemRequestDto;
import com.bizzjen.cipes.dto.KitchenItemResponseDto;
import com.bizzjen.cipes.service.KitchenItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KitchenItemController {
    private final KitchenItemService kitchenItemService;

    public KitchenItemController(KitchenItemService kitchenItemService) {
        this.kitchenItemService = kitchenItemService;
    }

    @PostMapping("/item")
    public ResponseEntity<KitchenItemResponseDto> createKitchenItem(@RequestBody KitchenItemRequestDto kitchenItemRequestDto) {
        return ResponseEntity.ok(this.kitchenItemService.createKitchenItem(kitchenItemRequestDto));
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<KitchenItemResponseDto> getItemById(@PathVariable long id){
        return ResponseEntity.ok(this.kitchenItemService.getKitchenItemById(id));
    }
}
