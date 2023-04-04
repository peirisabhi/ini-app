package com.abhi.iniapp.service.impl;

import com.abhi.iniapp.dto.OrderDto;
import com.abhi.iniapp.entity.*;
import com.abhi.iniapp.repository.*;
import com.abhi.iniapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    final
    VendorRepository vendorRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository, OrderInstallmentsRepository orderInstallmentsRepository, VendorRepository vendorRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.orderInstallmentsRepository = orderInstallmentsRepository;
        this.vendorRepository = vendorRepository;
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

    @Override
    public List<OrderDto> getOrdersByUserId (int id) {
        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getUserId() == id)
                .map(order -> order.toDto(OrderDto.class))
                .map(orderDto -> {
                    List<OrderInstallments> orderInstallments = orderInstallmentsRepository.findAll()
                            .stream()
                            .filter(oi -> oi.getOrderId() == orderDto.getId())
                            .collect(Collectors.toList());
                    orderDto.setOrderInstalmentsList(orderInstallments);
                    Product product = productRepository.findById(orderDto.getProductId()).get();
                    orderDto.setProductDesc(product.getDescription());
                    orderDto.setProductTitle(product.getTitle());
                    return orderDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByVendorId (int userId) {
        Vendor vendor = vendorRepository.findByUserId(userId);
        return orderRepository.findAll()
                .stream()
                .filter(order -> {
                    Product product = productRepository.findById(order.getProductId()).get();
                    return product.getVendorId() == vendor.getId();
                })
                .map(order -> order.toDto(OrderDto.class))
                .map(orderDto -> {
                    List<OrderInstallments> orderInstallments = orderInstallmentsRepository.findAll()
                            .stream()
                            .filter(oi -> oi.getOrderId() == orderDto.getId())
                            .collect(Collectors.toList());
                    orderDto.setOrderInstalmentsList(orderInstallments);
                    Product product = productRepository.findById(orderDto.getProductId()).get();
                    orderDto.setProductDesc(product.getDescription());
                    orderDto.setProductTitle(product.getTitle());
                    return orderDto;
                })
                .collect(Collectors.toList());
    }
}
