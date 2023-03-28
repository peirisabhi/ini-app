package com.abhi.iniapp.repository;

import com.abhi.iniapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 13:06
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
