package com.abhi.iniapp.controller;

import com.abhi.iniapp.dto.UserDto;
import com.abhi.iniapp.dto.VendorDto;
import com.abhi.iniapp.service.VendorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 20:58
 */
@RestController
@RequestMapping(value = "/api/vendor")
@Slf4j
@CrossOrigin
public class VendorController {

    @Autowired
    VendorService vendorService;

    @PostMapping
    public ResponseEntity<VendorDto> saveVendor(@RequestBody VendorDto vendorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.saveVendor(vendorDto));
    }

    @PutMapping
    public ResponseEntity<VendorDto> updateVendor(@RequestBody VendorDto vendorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(vendorService.updateVendor(vendorDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<VendorDto> updateVendor(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(vendorService.removeVendor(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<VendorDto> getVendor(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(vendorService.getVendor(id));
    }


    @GetMapping
    public ResponseEntity<List<VendorDto>> getVendors(){
        return ResponseEntity.status(HttpStatus.OK).body(vendorService.getVendors());
    }

}
