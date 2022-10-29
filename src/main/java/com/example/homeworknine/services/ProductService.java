package com.example.homeworknine.services;

import com.example.homeworknine.exceptions.NotFoundException;
import com.example.homeworknine.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Product createProduct(String name, BigDecimal price, Long idShop)throws NotFoundException;;

    Product updateProduct(Long idProduct,String name, BigDecimal price, Long idShop);

    void deleteProduct(Long idProduct) throws NotFoundException;

    Product getById(Long idProduct) throws NotFoundException;

    List<Product> getAllProducts();
}
