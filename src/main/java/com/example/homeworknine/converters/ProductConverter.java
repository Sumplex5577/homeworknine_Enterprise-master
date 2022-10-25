package com.example.homeworknine.converters;

import com.example.homeworknine.dtos.ProductDto;
import com.example.homeworknine.models.Product;

public class ProductConverter {
    public static ProductDto convertProductToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setShop(product.getShop());
        productDto.setShopId(product.getShop().getId());
        return productDto;
    }

    public static Product convertProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setShop(productDto.getShop());
        return product;
    }

}

