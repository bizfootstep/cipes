package com.bizzjen.cipes.controller;

import com.bizzjen.cipes.dto.KitchenTypeRequestDto;
import com.bizzjen.cipes.dto.KitchenTypeResponseDto;
import com.bizzjen.cipes.response.ResponseDetail;
import com.bizzjen.cipes.response.ResponseHandler;
import com.bizzjen.cipes.response.ResponseMessage;
import com.bizzjen.cipes.service.KitchenTypeService;
import jakarta.validation.Valid;
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
    public ResponseEntity<ResponseDetail> getKitchenTypeById(@PathVariable long id) {
        KitchenTypeResponseDto kitchenTypeResponseDto = this.kitchenTypeService.getKitchenTypeById(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, kitchenTypeResponseDto);
    }

    @PostMapping("/type")
    public ResponseEntity<ResponseDetail> createKitchenType(@RequestBody @Valid KitchenTypeRequestDto kitchenTypeRequestDto) {
        KitchenTypeResponseDto kitchenTypeResponseDto = this.kitchenTypeService.createKitchenType(kitchenTypeRequestDto);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, kitchenTypeResponseDto);
    }
}
