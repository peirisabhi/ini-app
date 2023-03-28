package com.abhi.iniapp.controller;

import com.abhi.iniapp.dto.UserDto;
import com.abhi.iniapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 27/03/2023
 * Time: 23:51
 */
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDto));
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(userDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.removeUser(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(value = "id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }


    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }

}
