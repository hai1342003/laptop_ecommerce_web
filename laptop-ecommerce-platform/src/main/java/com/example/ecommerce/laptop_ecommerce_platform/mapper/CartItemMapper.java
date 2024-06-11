package com.example.ecommerce.laptop_ecommerce_platform.mapper;

import com.example.ecommerce.laptop_ecommerce_platform.dto.*;
import com.example.ecommerce.laptop_ecommerce_platform.entity.*;
import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;


import java.util.stream.Collectors;

public class CartItemMapper {
    public static CartItemDto mapToCartItemDto(CartItem cartItem) {
        return new CartItemDto(
                cartItem.getId(),
                new LaptopDto(
                        cartItem.getLaptop().getId(),
                        cartItem.getLaptop().getName(),
                        cartItem.getLaptop().getBrand(),
                        cartItem.getLaptop().getDescription(),
                        cartItem.getLaptop().getPrice(),
                        cartItem.getLaptop().getQuantity(),
                        cartItem.getLaptop().getProcessor(),
                        cartItem.getLaptop().getRamSize(),
                        cartItem.getLaptop().getStorage(),
                        cartItem.getLaptop().getGraphicsCard(),
                        cartItem.getLaptop().getDisplay()
                ),
                cartItem.getQuantity()
        );
    }

    public static CartItem mapToCartItem(CartItemDto cartItemDto) {
        return new CartItem(
                cartItemDto.getId(),
                new Laptop(
                        cartItemDto.getLaptop().getId(),
                        cartItemDto.getLaptop().getName(),
                        cartItemDto.getLaptop().getBrand(),
                        cartItemDto.getLaptop().getDescription(),
                        cartItemDto.getLaptop().getPrice(),
                        cartItemDto.getLaptop().getQuantity(),
                        cartItemDto.getLaptop().getProcessor(),
                        cartItemDto.getLaptop().getRamSize(),
                        cartItemDto.getLaptop().getStorage(),
                        cartItemDto.getLaptop().getGraphicsCard(),
                        cartItemDto.getLaptop().getDisplay()
                ),
                cartItemDto.getQuantity()
        );
    }
}
