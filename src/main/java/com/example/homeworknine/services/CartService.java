package com.example.homeworknine.services;
import com.example.homeworknine.exceptions.NotFoundException;
import com.example.homeworknine.models.Cart;
import java.util.List;

public interface CartService {
    Cart createCartByPersonId(Long idPerson) throws NotFoundException;

    Cart addProductByProductIdAndCartId(Long idCart, Long idProduct) throws NotFoundException;

    Cart removeProductByProductIdAndCartId(Long idCart, Long idProduct) throws NotFoundException;

    void removeAllProductsFromCartById(Long idCart)throws NotFoundException;

    List<Cart> getAllCarts();

    Cart getCartById(Long idCart) throws NotFoundException;

    void removeCartById(Long idCart) throws NotFoundException;
}
