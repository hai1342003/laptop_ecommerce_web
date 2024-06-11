package com.example.ecommerce.laptop_ecommerce_platform.controller;

import com.example.ecommerce.laptop_ecommerce_platform.dto.AddressDto;
import com.example.ecommerce.laptop_ecommerce_platform.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        AddressDto savedAddress = addressService.createAddress(addressDto);
        return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("id") Long addressId) {
        AddressDto addressDto = addressService.getAddressById(addressId);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<AddressDto> getAddressByUserId(@PathVariable("user_id") Long userId) {
        AddressDto addressDto = addressService.getAddressByUserId(userId);
        return ResponseEntity.ok(addressDto);
    }
    @PutMapping("{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable("id") Long addressId,
                                                    @RequestBody AddressDto updatedAddress) {
        AddressDto addressDto = addressService.updateAddress(addressId, updatedAddress);
        return ResponseEntity.ok(addressDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable("id") Long addressId) {
        addressService.deleteAddress(addressId);
        return ResponseEntity.ok("Address deleted successfully!");
    }
}