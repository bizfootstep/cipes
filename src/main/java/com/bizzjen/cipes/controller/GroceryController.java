package com.bizzjen.cipes.controller;

import com.bizzjen.cipes.dto.GroceryRequestDto;
import com.bizzjen.cipes.dto.GroceryResponseDto;
import com.bizzjen.cipes.response.ResponseDetail;
import com.bizzjen.cipes.response.ResponseHandler;
import com.bizzjen.cipes.response.ResponseMessage;
import com.bizzjen.cipes.service.GroceryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroceryController {
    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping("/grocery/{id}")
    public ResponseEntity<ResponseDetail> getGroceryById(@PathVariable long id){
        GroceryResponseDto grocery = this.groceryService.getGroceryById(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, grocery);
    }

    @GetMapping("/groceries")
    public ResponseEntity<ResponseDetail> getGroceries(){
        List<GroceryResponseDto> groceryList = this.groceryService.getAllGrocery();
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, groceryList);
    }

    @PostMapping("/grocery")
    public ResponseEntity<ResponseDetail> createGrocery(@RequestBody GroceryRequestDto requestDto){
        GroceryResponseDto grocery = this.groceryService.createGrocery(requestDto);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, grocery);
    }



}
