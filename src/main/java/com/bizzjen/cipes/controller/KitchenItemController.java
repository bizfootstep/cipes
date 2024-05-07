package com.bizzjen.cipes.controller;

import com.bizzjen.cipes.dto.KitchenItemRequestDto;
import com.bizzjen.cipes.dto.KitchenItemResponseDto;
import com.bizzjen.cipes.response.ResponseDetail;
import com.bizzjen.cipes.response.ResponseHandler;
import com.bizzjen.cipes.response.ResponseMessage;
import com.bizzjen.cipes.service.KitchenItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class KitchenItemController {
    private final KitchenItemService kitchenItemService;

    public KitchenItemController(KitchenItemService kitchenItemService) {
        this.kitchenItemService = kitchenItemService;
    }

    @PostMapping("/item")
    public ResponseEntity<ResponseDetail> createKitchenItem(@RequestBody KitchenItemRequestDto kitchenItemRequestDto) {
        KitchenItemResponseDto kitchenItem = this.kitchenItemService.createKitchenItem(kitchenItemRequestDto);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, kitchenItem);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ResponseDetail> getItemById(@PathVariable long id){
        KitchenItemResponseDto kitchenItem = this.kitchenItemService.getKitchenItemById(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, kitchenItem);
    }
}
