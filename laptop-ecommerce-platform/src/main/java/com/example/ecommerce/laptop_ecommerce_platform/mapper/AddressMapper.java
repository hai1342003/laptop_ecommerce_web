package com.example.ecommerce.laptop_ecommerce_platform.mapper;

import com.example.ecommerce.laptop_ecommerce_platform.dto.AddressDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.UserDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Address;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;

public class AddressMapper {


    public static AddressDto mapToAddressDto(Address address) {
        return new AddressDto(
                address.getId(),
                new UserDto(
                        address.getUser().getId(),
                        address.getUser().getUsername(),
                        address.getUser().getRole()
                ),
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getCountry()
        );
    }

    public static Address mapToAddress(AddressDto addressDto) {
        return new Address(
                addressDto.getId(),
                new User(
                        addressDto.getUser().getId(),
                        addressDto.getUser().getName(),
                        addressDto.getUser().getRole()
                ),
                addressDto.getStreet(),
                addressDto.getCity(),
                addressDto.getState(),
                addressDto.getCountry()
        );
    }
}
