package com.example.ecommerce.laptop_ecommerce_platform.service.impl;

import com.example.ecommerce.laptop_ecommerce_platform.dto.CartDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Cart;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.exception.ResourceNotFoundException;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.CartItemMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.CartMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.LaptopMapper;
import com.example.ecommerce.laptop_ecommerce_platform.repository.CartRepository;
import com.example.ecommerce.laptop_ecommerce_platform.repository.LaptopRepository;
import com.example.ecommerce.laptop_ecommerce_platform.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private CartRepository cartRepository;

    @Override
    public CartDto createCart(CartDto cartDto) {
        Cart cart = CartMapper.mapToCart(cartDto);
        Cart savedCart = cartRepository.save(cart);
        return CartMapper.mapToCartDto(savedCart);
    }

    @Override
    public CartDto getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Cart is not exists with given id: " + cartId));

        return CartMapper.mapToCartDto(cart);
    }

    @Override
    public CartDto getCartByUserId(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);

        return CartMapper.mapToCartDto(cart);
    }

    @Override
    public List<CartDto> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return carts.stream().map((cart) -> CartMapper.mapToCartDto(cart))
                .collect(Collectors.toList());
    }

    @Override
    public CartDto updateCart(Long cartId, CartDto updatedCart) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new ResourceNotFoundException("Cart is not exists with given id" + cartId)
        );

        cart.setUser(updatedCart.getUser());
        cart.setCartItems(
                updatedCart.getCartItems().stream().map(CartItemMapper::mapToCartItem).collect(Collectors.toList())
        );
        Cart updatedCartObj = cartRepository.save(cart);

        return CartMapper.mapToCartDto(updatedCartObj);
    }

    @Override
    public void deleteCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(
                () -> new ResourceNotFoundException("Cart is not exists with given id" + cartId)
        );

        cartRepository.deleteById(cartId);
    }
}
