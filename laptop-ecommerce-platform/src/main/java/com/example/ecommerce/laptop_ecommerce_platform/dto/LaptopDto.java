package com.example.ecommerce.laptop_ecommerce_platform.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LaptopDto {
    private Long id;
    private String name;
    private String brand;
    private String description;
    private double price;
    private int quantity;
    private String processor;
    private String ramSize;
    private String storage;
    private String graphicsCard;
    private String display;
}
