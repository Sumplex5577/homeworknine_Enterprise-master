package com.example.homeworknine.controllers;

import com.example.homeworknine.converters.ShopConverter;
import com.example.homeworknine.dtos.ShopDto;
import com.example.homeworknine.services.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@Slf4j

public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }


    @RequestMapping(value = "/add_shop", method = RequestMethod.GET)
    public String addShopView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "addShop";
    }

    @RequestMapping(value = "/add_shop", method = RequestMethod.POST)
    public String addShop(@ModelAttribute("shop") ShopDto shopDto) {
        shopService.addShop(shopDto.getName());
        log.info("New Shop was created: {}", shopDto.getName());
        return "addShopSuccess";
    }

    @RequestMapping(value = "/remove_shop", method = RequestMethod.GET)
    public String removeShopByIdView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "removeShop";
    }

    @RequestMapping(value = "/remove_shop", method = {RequestMethod.DELETE, RequestMethod.POST})
    @Transactional
    public String removeShopById(@ModelAttribute("shop") ShopDto shopDto) {
        shopService.removeShopById(shopDto.getId());
        log.info("Shop was deleted successfully: {}", shopDto.getId());
        return "removeShopSuccess";
    }

    @GetMapping("/all_shops")
    public String getAllShops(Model model) {
        model.addAttribute("all", shopService.getAllShops().stream()
                .map(ShopConverter::convertShopToShopDto).collect(Collectors.toList()));
        return "allShops";
    }

    @RequestMapping(value = "/update_name", method = RequestMethod.GET)
    public String updateShopNameByIdView(Model model) {
        model.addAttribute("shop", new ShopDto());
        return "updateShopName";
    }

    @RequestMapping(value = "/update_name", method = {RequestMethod.PUT, RequestMethod.POST})
    @Transactional
    public String updateShopNameById(@ModelAttribute("shop") ShopDto shopDto) {
        shopService.updateShopNameById(shopDto.getId(), shopDto.getName());
        log.info("Shops Name was updated: {}", shopDto.getId());
        return "updateShopNameSuccess";
    }
}
