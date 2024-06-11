package com.example.ecommerce.laptop_ecommerce_platform.dto;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Cart;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private Long id;
    private LaptopDto laptop;
    private int quantity;

    public CartItemDto(Long id, int quantity) {
    }
}
