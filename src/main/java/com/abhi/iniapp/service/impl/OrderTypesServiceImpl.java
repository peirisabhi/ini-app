package com.abhi.iniapp.service.impl;

import com.abhi.iniapp.dto.OrderTypesDto;
import com.abhi.iniapp.repository.OrderTypesRepository;
import com.abhi.iniapp.service.OrderTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 29/03/2023
 * Time: 11:22
 */
@Service
public class OrderTypesServiceImpl implements OrderTypesService {

    @Autowired
    OrderTypesRepository orderTypesRepository;

    @Override
    public OrderTypesDto getOrderType(int id) {
        return orderTypesRepository.findById(id).get().toDto(OrderTypesDto.class);
    }

    @Override
    public List<OrderTypesDto> getOrderTypes() {
        return orderTypesRepository.findAll()
                .stream()
                .map(orderTypes -> orderTypes.toDto(OrderTypesDto.class))
                .collect(Collectors.toList());
    }
}
