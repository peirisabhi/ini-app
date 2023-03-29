package com.abhi.iniapp.service;

import com.abhi.iniapp.dto.OrderTypesDto;
import com.abhi.iniapp.dto.ProductDto;

import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 29/03/2023
 * Time: 11:18
 */
public interface OrderTypesService {

    OrderTypesDto getOrderType(int id);

    List<OrderTypesDto> getOrderTypes();
}
