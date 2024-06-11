package com.example.ecommerce.laptop_ecommerce_platform.mapper;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;

public class LaptopMapper {

    public static LaptopDto mapToLaptopDto(Laptop laptop) {
        return new LaptopDto(
                laptop.getId(),
                laptop.getName(),
                laptop.getBrand(),
                laptop.getDescription(),
                laptop.getPrice(),
                laptop.getQuantity(),
                laptop.getProcessor(),
                laptop.getRamSize(),
                laptop.getStorage(),
                laptop.getGraphicsCard(),
                laptop.getDisplay()
        );
    }

    public static Laptop mapToLaptop(LaptopDto laptopDto) {
        return new Laptop(
                laptopDto.getId(),
                laptopDto.getName(),
                laptopDto.getBrand(),
                laptopDto.getDescription(),
                laptopDto.getPrice(),
                laptopDto.getQuantity(),
                laptopDto.getProcessor(),
                laptopDto.getRamSize(),
                laptopDto.getStorage(),
                laptopDto.getGraphicsCard(),
                laptopDto.getDisplay()
        );
    }
}
