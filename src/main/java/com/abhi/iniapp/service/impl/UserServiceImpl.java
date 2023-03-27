package com.abhi.iniapp.service.impl;

import com.abhi.iniapp.dto.UserDto;
import com.abhi.iniapp.entity.User;
import com.abhi.iniapp.repository.UserRepository;
import com.abhi.iniapp.repository.UserRoleRepository;
import com.abhi.iniapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 27/03/2023
 * Time: 23:45
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDto saveUser(UserDto userDto) {

        User user = userDto.toEntity(User.class);
        user.setStatus(1);
        user.setRegisteredAt(new Date());

        return userRepository.save(user)
                .toDto(UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto removeUser(int id) {
        return null;
    }

    @Override
    public UserDto getUser(int id) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return null;
    }
}
