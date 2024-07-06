package com.example.ecommerce.laptop_ecommerce_platform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "laptop_id")
    private Laptop laptop;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int rating;
    private String comment;
    private LocalDateTime reviewDate;
}
