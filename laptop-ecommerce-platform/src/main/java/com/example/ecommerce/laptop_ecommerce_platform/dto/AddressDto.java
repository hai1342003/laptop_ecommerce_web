package com.example.ecommerce.laptop_ecommerce_platform.dto;

import com.example.ecommerce.laptop_ecommerce_platform.entity.User;
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
public class AddressDto {
    private Long id;

    private UserDto user;

    private String street;
    private String city;
    private String state;
    private String country;
}
