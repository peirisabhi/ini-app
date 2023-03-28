package com.abhi.iniapp.controller;

import com.abhi.iniapp.dto.ProductDto;
import com.abhi.iniapp.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 29/03/2023
 * Time: 00:29
 */
@RestController
@RequestMapping(value = "/api/product")
@Slf4j
@CrossOrigin
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(productDto));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.updateProduct(productDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.removeProduct(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(id));
    }


    @GetMapping
    public ResponseEntity<List<ProductDto>> getProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts());
    }


}
