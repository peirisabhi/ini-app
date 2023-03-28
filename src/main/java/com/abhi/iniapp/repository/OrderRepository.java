package com.abhi.iniapp.repository;

import com.abhi.iniapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 13:05
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
