package com.abhi.iniapp.service.impl;

import com.abhi.iniapp.dto.AuthDto;
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
import java.util.stream.Collectors;

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
        user.setUserRoleId(1);

        return userRepository.save(user)
                .toDto(UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        User user = userRepository.findById(userDto.getId())
                .get();
        user.setUserRoleId(userDto.getUserRoleId());
        user.setFname(userDto.getFname());
        user.setLname(userDto.getLname());
        user.setEmail(userDto.getEmail());

        return userRepository.save(user).toDto(UserDto.class);
    }

    @Override
    public UserDto removeUser(int id) {
        User user = userRepository.findById(id)
                .get();
        user.setStatus(0);

        return userRepository.save(user).toDto(UserDto.class);
    }

    @Override
    public UserDto getUser(int id) {
        return userRepository.findByIdAndStatus(id, 1).toDto(UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
       return userRepository.findAll()
                .stream()
                .filter(user -> user.getStatus() == 1)
                .map(user -> user.toDto(UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto authenticate(AuthDto authDto) {
        User existingUser = userRepository.findByEmail(authDto.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(authDto.getPassword())) {
            return existingUser.toDto(UserDto.class);
        } else {
            return  null;
        }
    }
}
