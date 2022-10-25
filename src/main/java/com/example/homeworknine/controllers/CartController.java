package com.example.homeworknine.controllers;


import com.example.homeworknine.converters.CartConverter;
import com.example.homeworknine.converters.ProductConverter;
import com.example.homeworknine.dtos.ProductDto;
import com.example.homeworknine.services.CartService;
import com.example.homeworknine.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

import static com.example.homeworknine.converters.CartConverter.convertCartToCartDto;

@Controller
@Slf4j

public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    private final HttpServletRequest httpServletRequest;

    public CartController(CartService cartService, ProductService productService, HttpServletRequest httpServletRequest) {
        this.cartService = cartService;
        this.productService = productService;
        this.httpServletRequest = httpServletRequest;
    }

    @RequestMapping(value = "/add_cart", method = {RequestMethod.POST, RequestMethod.GET})
    public String addCart() {
        cartService.addCartByPersonUsername(httpServletRequest.getUserPrincipal().getName());
        log.info("New Cart was added for the user: {}", httpServletRequest.getUserPrincipal().getName());
        return "redirect:/person_carts";
    }

    @RequestMapping(value = "/remove_cart", method = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.GET})
    @Transactional
    public String removeCartById(@RequestParam Long id) {
        cartService.removeCartById(id);
        log.info("Cart was deleted: {}", id);
        return "redirect:/person_carts";
    }

    @RequestMapping(value = "/get_cart", method = RequestMethod.GET)
    public String getCartById(@RequestParam Long id, Model model) {
        model.addAttribute("cart", convertCartToCartDto(cartService.getCartById(id)));
        return "getCartSuccess";
    }

    @GetMapping("/all_carts")
    public String getAllCarts(Model model) {
        model.addAttribute("all", cartService.getAllCarts().stream()
                .map(CartConverter::convertCartToCartDto).collect(Collectors.toList()));
        return "allCarts";
    }

    @GetMapping("/person_carts")
    public String getAllPersonCarts(Model model) {
        model.addAttribute("allPersonsCarts",
                cartService.getAllPersonCarts(httpServletRequest.getUserPrincipal().getName())
                        .stream().map(CartConverter::convertCartToCartDto).collect(Collectors.toList()));
        return "allPersonsCarts";
    }

    @RequestMapping(value = "/add_to_cart", method = RequestMethod.GET)
    public String addProductByProductIdView(Model model) {
        model.addAttribute("allCarts",
                cartService.getAllPersonCarts(httpServletRequest.getUserPrincipal().getName())
                        .stream().map(CartConverter::convertCartToCartDto).collect(Collectors.toList()));
        model.addAttribute("allProducts", productService.getAllProducts().stream()
                .map(ProductConverter::convertProductToProductDto).collect(Collectors.toList()));
        model.addAttribute("product", new ProductDto());
        return "addProductToCart";
    }

    @RequestMapping(value = "/add_to_cart", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String addProductByProductId(@ModelAttribute("product") ProductDto productDto) {
        cartService.addProductByProductId(productDto.getCartId(), productDto.getId());
        log.info("Product #{}, was added to the Cart #{} ", productDto.getId(), productDto.getCartId());
        return "redirect:/get_cart?id=" + productDto.getCartId();
    }

    @RequestMapping(value = "/remove_from_cart", method = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.GET})
    @Transactional
    public String removeProductByProductId(@RequestParam Long cartId, @RequestParam Long productId) {
        cartService.removeProductByProductId(cartId, productId);
        log.info("Product #{}, was removed from the cart #{} ", productId, cartId);
        return "redirect:/get_cart?id=" + cartId;
    }

    @RequestMapping(value = "/remove_all", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String removeAllProductsById(@RequestParam Long id) {
        cartService.removeAllProductsById(id);
        log.info("Congratulations! All products were removed from the CART!! #{} ", id);
        return "redirect:/person_carts";
    }

}
