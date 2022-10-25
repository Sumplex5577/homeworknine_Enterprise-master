package com.example.homeworknine.converters;

import com.example.homeworknine.dtos.CartDto;
import com.example.homeworknine.models.Cart;

public class CartConverter {

    public static CartDto convertCartToCartDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setPerson(cart.getPerson());
        cartDto.setProducts(cart.getProducts());
        cartDto.setAmountOfProducts(cart.getAmountOfProducts());
        cartDto.setSum(cart.getSum());
        return cartDto;
    }

    public static Cart convertCartDtoToCart(CartDto cartDto) {
        Cart cart = new Cart();
        cart.setId(cartDto.getId());
        cart.setPerson(cartDto.getPerson());
        cart.setProducts(cartDto.getProducts());
        cart.setAmountOfProducts(cartDto.getAmountOfProducts());
        cart.setSum(cartDto.getSum());
        return cart;
    }
}

