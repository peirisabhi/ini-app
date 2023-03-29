package com.abhi.iniapp.service.impl;

import com.abhi.iniapp.dto.OrderDto;
import com.abhi.iniapp.entity.Order;
import com.abhi.iniapp.entity.OrderInstallments;
import com.abhi.iniapp.entity.Product;
import com.abhi.iniapp.repository.OrderInstallmentsRepository;
import com.abhi.iniapp.repository.OrderRepository;
import com.abhi.iniapp.repository.ProductRepository;
import com.abhi.iniapp.repository.UserRepository;
import com.abhi.iniapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 29/03/2023
 * Time: 13:46
 */
@Service
public class OrderServiceImpl implements OrderService {

    final
    OrderRepository orderRepository;

    final
    UserRepository userRepository;

    final
    ProductRepository productRepository;

    final
    OrderInstallmentsRepository orderInstallmentsRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository, OrderInstallmentsRepository orderInstallmentsRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderInstallmentsRepository = orderInstallmentsRepository;
    }


    @Override
    public OrderDto saveOrder(OrderDto orderDto) {

        Order order = orderDto.toEntity(Order.class);
        Product product = productRepository.findById(orderDto.getProductId()).get();

        order.setOrderDate(new Date());
        order.setStatus(1);
        order.setPrice(product.getPrice());
        order = orderRepository.save(order);
//        if (orderDto.getOrderTypeId() == 1) {
//            order = orderRepository.save(order);
//        } else
            if (orderDto.getOrderTypeId() == 2) {
                double price = Math.round((product.getPrice() / 2) * 100.0) / 100.0;
            for (int i = 0; i < 2; i++) {

                OrderInstallments orderInstallments = new OrderInstallments();
                if (i == 0) {
                    orderInstallments.setOrderId(order.getId());
                    orderInstallments.setStatus("Paid");
                    orderInstallments.setDueDate(new Date());
                    orderInstallments.setPaiedDate(new Date());
                    orderInstallments.setPrice(price);

                }else {
                    LocalDate date = LocalDate.now();
                    LocalDate newDate = date.plusMonths(1);
                    Date nextDueDate;
                    try {
                        nextDueDate = new SimpleDateFormat("yyyy-MM-dd").parse(newDate.toString());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    orderInstallments.setStatus("Pending");
                    orderInstallments.setDueDate(nextDueDate);
                    orderInstallments.setPrice(price);
                    orderInstallments.setOrderId(order.getId());
                }

                orderInstallmentsRepository.save(orderInstallments);
            }
        } else if (orderDto.getOrderTypeId() == 3) {
                double price = Math.round((product.getPrice() / 3) * 100.0) / 100.0;

            for (int i = 0; i < 3; i++) {
                    OrderInstallments orderInstallments = new OrderInstallments();
                if (i == 0) {
                    orderInstallments.setOrderId(order.getId());
                    orderInstallments.setStatus("Paid");
                    orderInstallments.setDueDate(new Date());
                    orderInstallments.setPaiedDate(new Date());
                    orderInstallments.setPrice(price);

                }else {
                    LocalDate date = LocalDate.now();
                    LocalDate newDate = date.plusMonths(i);
                    Date nextDueDate;
                    try {
                        nextDueDate = new SimpleDateFormat("yyyy-MM-dd").parse(newDate.toString());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    orderInstallments.setStatus("Pending");
                    orderInstallments.setDueDate(nextDueDate);
                    orderInstallments.setPrice(price);
                    orderInstallments.setOrderId(order.getId());
                }
                    orderInstallmentsRepository.save(orderInstallments);
            }
        }

        return order.toDto(OrderDto.class);
    }

    @Override
    public OrderDto getOrder(int id) {
        return orderRepository.findById(id).get().toDto(OrderDto.class);
    }
}
