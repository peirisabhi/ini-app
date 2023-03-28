package com.abhi.iniapp.service.impl;

import com.abhi.iniapp.dto.ProductDto;
import com.abhi.iniapp.entity.Product;
import com.abhi.iniapp.repository.ProductRepository;
import com.abhi.iniapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Intellij.
 * Author: Abhishek Peiris
 * Date: 28/03/2023
 * Time: 23:39
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = productDto.toEntity(Product.class);
        product.setStatus(1);
        product.setRegisteredAt(new Date());

        return productRepository.save(product).toDto(ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        Product product = productRepository.findById(productDto.getId()).get();
        product.setTitle(productDto.getTitle());
        product.setImage(productDto.getImage());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        return productRepository.save(product).toDto(ProductDto.class);
    }

    @Override
    public ProductDto removeProduct(int id) {
        Product product = productRepository.findById(id).get();
        product.setStatus(0);

        return productRepository.save(product).toDto(ProductDto.class);
    }

    @Override
    public ProductDto getProduct(int id) {
        return productRepository.findById(id).get().toDto(ProductDto.class);
    }

    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getStatus() == 1)
                .map(product -> product.toDto(ProductDto.class))
                .collect(Collectors.toList());
    }
}
