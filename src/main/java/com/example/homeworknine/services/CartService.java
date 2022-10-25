package com.example.homeworknine.services;
import com.example.homeworknine.models.Cart;
import java.util.List;

public interface CartService {
    void addCartByPersonUsername(String username);

    void removeCartById(Long id);

    Cart getCartById(Long id);

    List<Cart> getAllCarts();

    List<Cart> getAllPersonCarts(String username);

    void addProductByProductId(Long cartId, Long productId);

    void removeProductByProductId(Long cartId, Long productId);

    void removeAllProductsById(Long id);

}

