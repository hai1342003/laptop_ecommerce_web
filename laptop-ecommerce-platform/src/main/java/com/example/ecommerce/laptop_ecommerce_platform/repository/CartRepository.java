package com.example.ecommerce.laptop_ecommerce_platform.repository;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Address;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUserId(Long userId);

}
