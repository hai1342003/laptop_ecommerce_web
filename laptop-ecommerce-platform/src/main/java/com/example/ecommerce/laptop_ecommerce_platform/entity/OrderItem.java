package com.example.ecommerce.laptop_ecommerce_platform.entity;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
//import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
//@RedisHash("OrderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    private int quantity;
    private double price;

    public OrderItem(Long id, LaptopDto laptop, int quantity, double price) {
    }
}
