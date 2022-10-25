package com.example.homeworknine.dtos;

import com.example.homeworknine.models.Person;
import com.example.homeworknine.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartDto {
    private Long id;
    private Person person;
    private List<Product> products;
    private Integer amountOfProducts;
    private BigDecimal sum;
}
