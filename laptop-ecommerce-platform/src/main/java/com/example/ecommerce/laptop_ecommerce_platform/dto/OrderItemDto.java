package com.example.ecommerce.laptop_ecommerce_platform.dto;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Long id;
    private LaptopDto laptop;
    private int quantity;
    private double price;

    public OrderItemDto(Long id, Laptop laptop, int quantity, double price) {
    }
}
