package com.example.ecommerce.laptop_ecommerce_platform.service.impl;

import com.example.ecommerce.laptop_ecommerce_platform.dto.OrderDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.*;
import com.example.ecommerce.laptop_ecommerce_platform.exception.ResourceNotFoundException;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.AddressMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.CartMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.LaptopMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.OrderMapper;
import com.example.ecommerce.laptop_ecommerce_platform.repository.LaptopRepository;
import com.example.ecommerce.laptop_ecommerce_platform.repository.OrderRepository;
import com.example.ecommerce.laptop_ecommerce_platform.service.OrderService;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.mapToOrderDto(savedOrder);
    }


    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Order is not exists with given id: " + orderId));

        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public OrderDto getOrderByUserId(Long userId) {
        Order order = orderRepository.findByUserId(userId);

        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public OrderDto getOrderByStatus(String status) {
        Order order = orderRepository.findByStatus(status);

        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map((order) -> OrderMapper.mapToOrderDto(order))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long orderId, OrderDto updatedOrder) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order is not exists with given id" + orderId)
        );

        order.setUser(
                new User(
                        updatedOrder.getUser().getId(),
                        updatedOrder.getUser().getName()
                )
        );

        order.setOrderDate(updatedOrder.getOrderDate());
        order.setStatus(updatedOrder.getStatus());
        order.setShippingAddress(updatedOrder.getShippingAddress());

        Order updatedOrderObj = orderRepository.save(order);

        return OrderMapper.mapToOrderDto(updatedOrderObj);
    }

    @Override
    public void deleteOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Order is not exists with given id" + orderId)
        );

        orderRepository.deleteById(orderId);
    }
}
