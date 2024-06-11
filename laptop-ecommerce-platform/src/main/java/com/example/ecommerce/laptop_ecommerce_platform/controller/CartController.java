package com.example.ecommerce.laptop_ecommerce_platform.controller;

import com.example.ecommerce.laptop_ecommerce_platform.dto.CartDto;
import com.example.ecommerce.laptop_ecommerce_platform.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/carts")
public class CartController {
    private CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCart(@RequestBody CartDto cartDto) {
        CartDto savedCart = cartService.createCart(cartDto);
        return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("id") Long cartId) {
        CartDto cartDto = cartService.getCartById(cartId);
        return ResponseEntity.ok(cartDto);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<CartDto> getCartByUserId(@PathVariable("userId") Long userId) {
        CartDto cartDto = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cartDto);
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getAllCarts() {
        List<CartDto> carts = cartService.getAllCarts();
        return ResponseEntity.ok(carts);
    }

    @PutMapping("{id}")
    public ResponseEntity<CartDto> updateCart(@PathVariable("id") Long cartId,
                                              @RequestBody CartDto updatedCart) {
        CartDto cartDto = cartService.updateCart(cartId, updatedCart);
        return ResponseEntity.ok(cartDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCart(@PathVariable("id") Long cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.ok("Cart deleted successfully!");
    }
}