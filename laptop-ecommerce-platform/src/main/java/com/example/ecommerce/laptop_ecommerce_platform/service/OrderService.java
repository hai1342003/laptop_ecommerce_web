package com.example.ecommerce.laptop_ecommerce_platform.service;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);


    OrderDto getOrderById(Long orderId);

    OrderDto getOrderByUserId(Long userId);

    OrderDto getOrderByStatus(String status);

    List<OrderDto> getAllOrders();

    OrderDto updateOrder(Long orderId, OrderDto updatedOrder);

    void deleteOrder(Long orderId);
}
