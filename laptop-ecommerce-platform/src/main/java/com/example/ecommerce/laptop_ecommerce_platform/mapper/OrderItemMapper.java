package com.example.ecommerce.laptop_ecommerce_platform.mapper;

import com.example.ecommerce.laptop_ecommerce_platform.dto.CartItemDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.OrderItemDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.CartItem;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Order;
import com.example.ecommerce.laptop_ecommerce_platform.entity.OrderItem;

public class OrderItemMapper {
    public static OrderItemDto mapToOrderItemDto(OrderItem orderItem) {
        return new OrderItemDto(
                orderItem.getId(),
                orderItem.getLaptop(),
                orderItem.getQuantity(),
                orderItem.getPrice()

        );
    }

    public static OrderItem mapToOrderItem(OrderItemDto orderItemDto) {
        return new OrderItem(
                orderItemDto.getId(),
                orderItemDto.getLaptop(),
                orderItemDto.getQuantity(),
                orderItemDto.getPrice()
        );
    }
}
