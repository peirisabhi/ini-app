package com.abhi.iniapp.service;

import com.abhi.iniapp.dto.OrderDto;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 29/03/2023
 * Time: 13:44
 */
public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);

    OrderDto getOrder(int id);


}
