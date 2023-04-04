package com.abhi.iniapp.controller;

import com.abhi.iniapp.dto.OrderDto;
import com.abhi.iniapp.dto.ProductDto;
import com.abhi.iniapp.service.OrderService;
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
 * Time: 16:45
 */
@RestController
@RequestMapping(value = "/api/order")
@Slf4j
@CrossOrigin
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> saveProduct(@RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(orderDto));
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getProduct(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrder(id));
    }

    @GetMapping("/getOrdersByUserId/{id}")
    public ResponseEntity<List<OrderDto>> getOrdersByUserId(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrdersByUserId(id));
    }

    @GetMapping("/getOrdersByVendorId/{id}")
    public ResponseEntity<List<OrderDto>> getOrdersByVendorId(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrdersByVendorId(id));
    }
}
