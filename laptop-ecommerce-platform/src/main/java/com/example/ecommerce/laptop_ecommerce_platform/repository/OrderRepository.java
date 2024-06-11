package com.example.ecommerce.laptop_ecommerce_platform.repository;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Cart;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByUserId(Long userId);
    Order findByStatus(String status);
}
