package com.example.ecommerce.laptop_ecommerce_platform.service;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;

import java.util.List;

public interface LaptopService {
    LaptopDto createLaptop(LaptopDto laptopDto);


    LaptopDto getLaptopById(Long laptopId);


    LaptopDto getLaptopByBrand(String brand);

    List<LaptopDto> getAllLaptops();

    LaptopDto updateLaptop(Long laptopId, LaptopDto updatedLaptop);

    void deleteLaptop(Long laptopId);
}
