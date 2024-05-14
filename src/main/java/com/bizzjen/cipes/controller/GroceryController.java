package com.bizzjen.cipes.controller;

import com.bizzjen.cipes.dto.GroceryCategoryRequestDto;
import com.bizzjen.cipes.dto.GroceryRequestDto;
import com.bizzjen.cipes.dto.GroceryResponseDto;
import com.bizzjen.cipes.response.ResponseDetail;
import com.bizzjen.cipes.response.ResponseHandler;
import com.bizzjen.cipes.response.ResponseMessage;
import com.bizzjen.cipes.service.GroceryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    private static final Logger logger = LoggerFactory.getLogger(GroceryController.class);
    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDetail> getGroceryById(@PathVariable long id) {
        GroceryResponseDto grocery = this.groceryService.getGroceryById(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, grocery);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDetail> getGroceries() {
        logger.info("Get All of the Groceries information!");
        List<GroceryResponseDto> groceryList = this.groceryService.getAllGrocery();
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, groceryList);
    }

    @PostMapping
    public ResponseEntity<ResponseDetail> createGrocery(@RequestBody GroceryRequestDto requestDto) {
        GroceryResponseDto grocery = this.groceryService.createGrocery(requestDto);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(), HttpStatus.OK, grocery);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseDetail> getCategoryById(@PathVariable int id) {
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(),
                HttpStatus.OK, this.groceryService.getGroceryCategoryById(id));
    }

    @GetMapping("/category/all")
    public ResponseEntity<ResponseDetail> getCategories() {
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(),
                HttpStatus.OK, this.groceryService.getAllGroceryCategory());
    }

    @PostMapping("/category")
    public ResponseEntity<ResponseDetail> createCategory(@RequestBody GroceryCategoryRequestDto categoryRequestDto) {
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.name(),
                HttpStatus.OK, this.groceryService.createGroceryCategory(categoryRequestDto));
    }

    @DeleteMapping("/category/all")
    public ResponseEntity<ResponseDetail> deleteAllCategories() {
        this.groceryService.deleteAllGrocery();
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(),
                HttpStatus.OK,
                null
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDetail> deleteGroceryById(@PathVariable int id){
        this.groceryService.deleteGroceryById(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(),HttpStatus.OK, null);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<ResponseDetail> deleteCategoryById(@PathVariable int id){
        this.groceryService.deleteCategoryById(id);
        return ResponseHandler.responseBuilder(ResponseMessage.REQUEST_SUCCESSFUL.getDescription(),HttpStatus.OK, null);
    }

}
