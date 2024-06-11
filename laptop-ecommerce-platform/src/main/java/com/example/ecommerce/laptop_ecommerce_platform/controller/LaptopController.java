package com.example.ecommerce.laptop_ecommerce_platform.controller;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.service.LaptopService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    private LaptopService laptopService;

    @PostMapping
    public ResponseEntity<LaptopDto> createLaptop(@RequestBody LaptopDto laptopDto) {
        LaptopDto savedLaptop = laptopService.createLaptop(laptopDto);
        return new ResponseEntity<>(savedLaptop, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<LaptopDto> getLaptopById(@PathVariable("id") Long laptopId) {
        LaptopDto laptopDto = laptopService.getLaptopById(laptopId);
        return ResponseEntity.ok(laptopDto);
    }

    @GetMapping("brand/{brand}")
    public ResponseEntity<LaptopDto> getLaptopByBrand(@PathVariable("brand") String brand) {
        LaptopDto laptopDto = laptopService.getLaptopByBrand(brand);
        return ResponseEntity.ok(laptopDto);
    }
    @GetMapping
    public ResponseEntity<List<LaptopDto>> getAllLaptops() {
        List<LaptopDto> laptops = laptopService.getAllLaptops();
        return ResponseEntity.ok(laptops);
    }

    @PutMapping("{id}")
    public ResponseEntity<LaptopDto> updateLaptop(@PathVariable("id") Long laptopId,
                                                  @RequestBody LaptopDto updatedLaptop) {
        LaptopDto laptopDto = laptopService.updateLaptop(laptopId, updatedLaptop);
        return ResponseEntity.ok(laptopDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLaptop(@PathVariable("id") Long laptopId) {
        laptopService.deleteLaptop(laptopId);
        return ResponseEntity.ok("Laptop deleted successfully!");
    }
}
