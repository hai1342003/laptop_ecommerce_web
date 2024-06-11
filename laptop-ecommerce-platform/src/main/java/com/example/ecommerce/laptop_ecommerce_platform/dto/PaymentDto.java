package com.example.ecommerce.laptop_ecommerce_platform.dto;

import com.example.ecommerce.laptop_ecommerce_platform.entity.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDto {
    private Long id;

    private OrderDto order;

    private String paymentMethod;
    private LocalDateTime paymentDate;
    private double amount;
}
