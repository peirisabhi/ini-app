package com.abhi.iniapp.controller;

import com.abhi.iniapp.dto.OrderTypesDto;
import com.abhi.iniapp.service.OrderTypesService;
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
 * Time: 11:28
 */
@RestController
@RequestMapping(value = "/api/order-types")
@Slf4j
@CrossOrigin
public class OrderTypesController {

    @Autowired
    OrderTypesService orderTypesService;

    @GetMapping("{id}")
    public ResponseEntity<OrderTypesDto> getOrderType(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(orderTypesService.getOrderType(id));
    }


    @GetMapping
    public ResponseEntity<List<OrderTypesDto>> getOrderTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(orderTypesService.getOrderTypes());
    }


}
