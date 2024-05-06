package com.bizzjen.cipes.controller;

import com.bizzjen.cipes.dto.KitchenTypeRequestDto;
import com.bizzjen.cipes.dto.KitchenTypeResponseDto;
import com.bizzjen.cipes.response.ResponseHandler;
import com.bizzjen.cipes.service.KitchenTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KitchenTypeController {
    // TODO: 03/05/2024 CRUD
    private final KitchenTypeService kitchenTypeService;

    public KitchenTypeController(KitchenTypeService kitchenTypeService) {
        this.kitchenTypeService = kitchenTypeService;
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<Object> getKitchenTypeById(@PathVariable long id) {
        KitchenTypeResponseDto kitchenTypeResponseDto = this.kitchenTypeService.getKitchenTypeById(id);
        return ResponseHandler.responseBuilder("hello", HttpStatus.OK, kitchenTypeResponseDto);
    }

    @PostMapping("/type")
    public ResponseEntity<KitchenTypeResponseDto> createKitchenType(@RequestBody KitchenTypeRequestDto kitchenTypeRequestDto) {
        KitchenTypeResponseDto kitchenTypeResponseDto = this.kitchenTypeService.createKitchenType(kitchenTypeRequestDto);
        return ResponseEntity.ok(kitchenTypeResponseDto);
    }
}
