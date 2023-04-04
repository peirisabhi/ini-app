package com.abhi.iniapp.service;

import com.abhi.iniapp.dto.OrderDto;
import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 29/03/2023
 * Time: 13:44
 */
public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);

    OrderDto getOrder(int id);

    List<OrderDto> getOrdersByUserId(int id);

    List<OrderDto> getOrdersByVendorId(int id);
}
