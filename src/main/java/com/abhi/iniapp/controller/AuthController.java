package com.abhi.iniapp.controller;

import com.abhi.iniapp.dto.AuthDto;
import com.abhi.iniapp.dto.OrderDto;
import com.abhi.iniapp.dto.UserDto;
import com.abhi.iniapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api")
@Slf4j
@CrossOrigin
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody AuthDto authDto){
        UserDto userDto = userService.authenticate(authDto);
        if (userDto == null) {
            return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(userDto);
        }
    }
}
