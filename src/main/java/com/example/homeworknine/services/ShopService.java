package com.example.homeworknine.services;

import com.example.homeworknine.exceptions.NotFoundException;
import com.example.homeworknine.models.Shop;

import java.util.List;

public interface ShopService {
    Shop createShop(Shop shop);

    void deleteShop(Long idShop) throws NotFoundException;

    Shop getShopById(Long idShop) throws NotFoundException;

    List<Shop> getAllShops();
}
