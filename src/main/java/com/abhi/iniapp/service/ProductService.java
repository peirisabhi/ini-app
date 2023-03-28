package com.abhi.iniapp.service;

import com.abhi.iniapp.dto.ProductDto;

import java.util.List;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 23:36
 */
public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    ProductDto removeProduct(int id);

    ProductDto getProduct(int id);

    List<ProductDto> getProducts();
}
