package com.example.ecommerce.laptop_ecommerce_platform.entity;

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
@Table(name = "laptops")
//@RedisHash("Laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "processor_type")
    private String processor;

    @Column(name = "ram_size")
    private String ramSize;

    @Column(name = "storage")
    private String storage;

    @Column(name = "graphic_card")
    private String graphicsCard;

    @Column(name = "display")
    private String display;
}
