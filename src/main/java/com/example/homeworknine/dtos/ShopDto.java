package com.example.homeworknine.dtos;

import com.example.homeworknine.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ShopDto {
    private Long idShop;
    private String name;
    private String link;
    private List<Product> products;

}



