package com.abhi.iniapp.service;

import com.abhi.iniapp.dto.AuthDto;
import com.abhi.iniapp.dto.UserDto;
import com.abhi.iniapp.entity.User;

import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 27/03/2023
 * Time: 23:39
 */
public interface UserService {

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    UserDto removeUser(int id);

    UserDto getUser(int id);

    List<UserDto> getUsers();

    UserDto authenticate(AuthDto authDto);

}
