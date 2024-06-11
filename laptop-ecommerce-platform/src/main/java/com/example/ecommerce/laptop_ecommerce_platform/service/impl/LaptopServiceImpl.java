package com.example.ecommerce.laptop_ecommerce_platform.service.impl;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.exception.ResourceNotFoundException;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.LaptopMapper;
import com.example.ecommerce.laptop_ecommerce_platform.repository.LaptopRepository;
import com.example.ecommerce.laptop_ecommerce_platform.service.LaptopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LaptopServiceImpl implements LaptopService {
    private LaptopRepository laptopRepository;


    @Override
    public LaptopDto createLaptop(LaptopDto laptopDto) {
        Laptop laptop = LaptopMapper.mapToLaptop(laptopDto);
        Laptop savedLaptop = laptopRepository.save(laptop);
        return LaptopMapper.mapToLaptopDto(savedLaptop);
    }

    @Override
    public LaptopDto getLaptopById(Long laptopId) {
        Laptop laptop = laptopRepository.findById(laptopId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Laptop is not exists with given id: " + laptopId));

        return LaptopMapper.mapToLaptopDto(laptop);
    }

    @Override
    public LaptopDto getLaptopByBrand(String brand) {
        Laptop laptop = laptopRepository.findByBrand(brand);

        return LaptopMapper.mapToLaptopDto(laptop);
    }

    @Override
    public List<LaptopDto> getAllLaptops() {
        List<Laptop> laptops = laptopRepository.findAll();
        return laptops.stream().map((laptop) -> LaptopMapper.mapToLaptopDto(laptop))
                .collect(Collectors.toList());
    }

    @Override
    public LaptopDto updateLaptop(Long laptopId, LaptopDto updatedLaptop) {

        Laptop laptop = laptopRepository.findById(laptopId).orElseThrow(
                () -> new ResourceNotFoundException("Laptop is not exists with given id" + laptopId)
        );

        laptop.setName(updatedLaptop.getName());
        laptop.setBrand(updatedLaptop.getBrand());
        laptop.setDescription(updatedLaptop.getDescription());
        laptop.setPrice(updatedLaptop.getPrice());
        laptop.setQuantity(updatedLaptop.getQuantity());
        laptop.setProcessor(updatedLaptop.getProcessor());
        laptop.setRamSize(updatedLaptop.getRamSize());
        laptop.setStorage(updatedLaptop.getStorage());
        laptop.setGraphicsCard(updatedLaptop.getGraphicsCard());
        laptop.setDisplay(updatedLaptop.getDisplay());

        Laptop updatedLaptopObj = laptopRepository.save(laptop);

        return LaptopMapper.mapToLaptopDto(updatedLaptopObj);
    }

    @Override
    public void deleteLaptop(Long laptopId) {
        Laptop laptop = laptopRepository.findById(laptopId).orElseThrow(
                () -> new ResourceNotFoundException("Laptop is not exists with given id" + laptopId)
        );

        laptopRepository.deleteById(laptopId);
    }


}
