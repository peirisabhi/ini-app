package com.abhi.iniapp.service.impl;

import com.abhi.iniapp.dto.VendorDto;
import com.abhi.iniapp.entity.User;
import com.abhi.iniapp.entity.Vendor;
import com.abhi.iniapp.repository.UserRepository;
import com.abhi.iniapp.repository.VendorRepository;
import com.abhi.iniapp.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 13:10
 */
@Service
public class VendorServiceImpl implements VendorService {

    final
    VendorRepository vendorRepository;

    final
    UserRepository userRepository;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository, UserRepository userRepository) {
        this.vendorRepository = vendorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public VendorDto saveVendor(VendorDto vendorDto) {

        User user = User.builder()
                .fname(vendorDto.getFname())
                .lname(vendorDto.getLname())
                .email(vendorDto.getEmail())
                .password(vendorDto.getPassword())
                .userRoleId(3) //vendor
                .status(1)
                .registeredAt(new Date())
                .build();

        user = userRepository.save(user);

        Vendor vendor = vendorDto.toDto(Vendor.class);
        vendor.setUserId(user.getId());

       vendor = vendorRepository.save(vendor);
       vendorDto.setId(vendor.getId());

       return vendorDto;
    }

    @Override
    public VendorDto updateVendor(VendorDto vendorDto) {
        return null;
    }

    @Override
    public VendorDto removeVendor(int id) {
        Vendor vendor = vendorRepository.findById(id).get();
        User user = userRepository.findById(vendor.getUserId()).get();
        user.setStatus(0);
        userRepository.save(user);

        return vendor.toDto(VendorDto.class);
    }

    @Override
    public VendorDto getVendor(int id) {

        Vendor vendor = vendorRepository.findById(id).get();
        User user = userRepository.findById(vendor.getUserId()).get();

        VendorDto vendorDto = vendor.toDto(VendorDto.class);
        vendorDto.setLname(user.getLname());
        vendorDto.setFname(user.getFname());
        vendorDto.setEmail(user.getEmail());

        return vendorDto;
    }

    @Override
    public List<VendorDto> getVendors() {
       return vendorRepository.findAll()
                .stream()
                .filter(vendor -> {
                    User user = userRepository.findById(vendor.getUserId()).get();
                   return user.getStatus() == 1;
                })
                .map(vendor -> {
                    VendorDto vendorDto = vendor.toDto(VendorDto.class);
                    User user = userRepository.findById(vendor.getUserId()).get();
                    vendorDto.setEmail(user.getEmail());
                    vendorDto.setLname(user.getLname());
                    vendorDto.setFname(user.getFname());

                    return vendorDto;
                })
                .collect(Collectors.toList());
    }
}
