package com.abhi.iniapp.repository;

import com.abhi.iniapp.entity.OrderInstallments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 13:05
 */
public interface OrderInstallmentsRepository extends JpaRepository<OrderInstallments, Integer> {
}
