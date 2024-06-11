package com.example.ecommerce.laptop_ecommerce_platform.controller;

import com.example.ecommerce.laptop_ecommerce_platform.dto.OrderDto;
import com.example.ecommerce.laptop_ecommerce_platform.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto savedOrder = orderService.createOrder(orderDto);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<OrderDto> getOrderByUserId(@PathVariable("userId") Long userId) {
        OrderDto orderDto = orderService.getOrderByUserId(userId);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping("status/{status}")
    public ResponseEntity<OrderDto> getOrderByStatus(@PathVariable("status") String status) {
        OrderDto orderDto = orderService.getOrderByStatus(status);
        return ResponseEntity.ok(orderDto);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("id") Long orderId,
                                                @RequestBody OrderDto updatedOrder) {
        OrderDto orderDto = orderService.updateOrder(orderId, updatedOrder);
        return ResponseEntity.ok(orderDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully!");
    }
}