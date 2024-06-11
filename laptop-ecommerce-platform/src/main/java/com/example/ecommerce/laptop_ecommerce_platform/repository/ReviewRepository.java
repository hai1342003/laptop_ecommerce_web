package com.example.ecommerce.laptop_ecommerce_platform.repository;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Cart;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByLaptopId(Long laptopId);
}
