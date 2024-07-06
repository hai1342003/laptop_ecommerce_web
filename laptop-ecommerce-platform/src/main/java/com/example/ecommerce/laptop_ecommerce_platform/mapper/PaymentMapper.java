package com.example.ecommerce.laptop_ecommerce_platform.mapper;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.OrderDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.PaymentDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.UserDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Order;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Payment;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;

public class PaymentMapper {
    public static PaymentDto mapToPaymentDto(Payment payment) {
        return new PaymentDto(
                payment.getId(),
                new OrderDto(
                        payment.getOrder().getId(),
                        new UserDto(
                                payment.getOrder().getUser().getId(),
                                payment.getOrder().getUser().getUsername()

                        ),
                        payment.getOrder().getOrderDate(),
                        payment.getOrder().getStatus(),
                        payment.getOrder().getShippingAddress()
                ),
                payment.getPaymentMethod(),
                payment.getPaymentDate(),
                payment.getAmount()
        );
    }

    public static Payment mapToPayment(PaymentDto paymentDto) {
        return new Payment(
                paymentDto.getId(),
                new Order(
                        paymentDto.getOrder().getId(),
                        new User(
                                paymentDto.getOrder().getUser().getId(),
                                paymentDto.getOrder().getUser().getName()
                        ),
                        paymentDto.getOrder().getOrderDate(),
                        paymentDto.getOrder().getStatus(),
                        paymentDto.getOrder().getShippingAddress()
                ),
                paymentDto.getPaymentMethod(),
                paymentDto.getPaymentDate(),
                paymentDto.getAmount()
        );
    }
}
