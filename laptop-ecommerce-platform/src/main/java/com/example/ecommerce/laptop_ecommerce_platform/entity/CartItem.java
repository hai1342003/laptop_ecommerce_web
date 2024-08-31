package com.example.ecommerce.laptop_ecommerce_platform.entity;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart_items")
//@RedisHash("CartItem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    private int quantity;

    public CartItem(Long id, Laptop laptop, int quantity) {
    }
}
