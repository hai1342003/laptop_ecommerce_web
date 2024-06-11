package com.example.ecommerce.laptop_ecommerce_platform.dto;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Address;
import com.example.ecommerce.laptop_ecommerce_platform.entity.OrderItem;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private UserDto user;
    private LocalDateTime orderDate;
    private String status;
    private Address shippingAddress;
}
