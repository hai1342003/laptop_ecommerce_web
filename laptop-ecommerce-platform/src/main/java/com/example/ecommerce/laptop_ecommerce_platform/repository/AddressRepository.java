package com.example.ecommerce.laptop_ecommerce_platform.repository;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Address;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByUserId(Long userId);
}
