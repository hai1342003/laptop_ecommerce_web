package com.example.ecommerce.laptop_ecommerce_platform.service;

import com.example.ecommerce.laptop_ecommerce_platform.dto.CartDto;

import java.util.List;

public interface CartService {
    CartDto createCart(CartDto cartDto);


    CartDto getCartById(Long cartId);

    CartDto getCartByUserId(Long userId);
    List<CartDto> getAllCarts();

    CartDto updateCart(Long cartId, CartDto updatedCart);

    void deleteCart(Long cartId);
}
