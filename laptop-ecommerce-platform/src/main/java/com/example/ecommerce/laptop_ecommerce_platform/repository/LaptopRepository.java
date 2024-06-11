package com.example.ecommerce.laptop_ecommerce_platform.repository;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Address;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    Laptop findByBrand(String brand);
}
