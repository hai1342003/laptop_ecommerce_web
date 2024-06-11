package com.example.ecommerce.laptop_ecommerce_platform.service;

import com.example.ecommerce.laptop_ecommerce_platform.dto.AddressDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.UserDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);


    AddressDto getAddressById(Long addressId);

    AddressDto getAddressByUserId(Long userId);

    AddressDto updateAddress(Long addressId, AddressDto updatedAddress);

    void deleteAddress(Long addressId);
}
