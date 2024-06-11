package com.example.ecommerce.laptop_ecommerce_platform.dto;

import com.example.ecommerce.laptop_ecommerce_platform.entity.CartItem;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Long id;
    private User user;
    private List<CartItemDto> cartItems = new ArrayList<>();
}
