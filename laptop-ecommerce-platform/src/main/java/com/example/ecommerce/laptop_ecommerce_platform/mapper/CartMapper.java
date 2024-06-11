package com.example.ecommerce.laptop_ecommerce_platform.mapper;

import com.example.ecommerce.laptop_ecommerce_platform.dto.AddressDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.CartDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.CartItemDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Address;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Cart;
import com.example.ecommerce.laptop_ecommerce_platform.entity.CartItem;

import java.util.stream.Collectors;

public class CartMapper {
    public static CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getUser(),
                cart.getCartItems().stream().map(CartItemMapper::mapToCartItemDto).collect(Collectors.toList())
        );
    }

    public static Cart mapToCart(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getUser(),
                cartDto.getCartItems().stream().map(CartItemMapper::mapToCartItem).collect(Collectors.toList())
        );
    }
}
