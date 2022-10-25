package com.example.homeworknine.dtos;

import com.example.homeworknine.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDto {
    private Long id;
    private String name;
    private List<Product> products;

}


