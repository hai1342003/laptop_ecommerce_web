package com.example.ecommerce.laptop_ecommerce_platform.mapper;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.OrderDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.UserDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Order;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;

public class OrderMapper {
    public static OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                new UserDto(
                    order.getUser().getId(),
                    order.getUser().getUsername(),
                    order.getUser().getRole()
                ),
                order.getOrderDate(),
                order.getStatus(),
                order.getShippingAddress()
        );
    }

    public static Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                new User(
                        orderDto.getUser().getId(),
                        orderDto.getUser().getName(),
                        orderDto.getUser().getRole()
                ),
                orderDto.getOrderDate(),
                orderDto.getStatus(),
                orderDto.getShippingAddress()
        );
    }
}
