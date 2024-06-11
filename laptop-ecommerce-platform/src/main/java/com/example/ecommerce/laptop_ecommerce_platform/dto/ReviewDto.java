package com.example.ecommerce.laptop_ecommerce_platform.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private LaptopDto laptop;
    private UserDto user;
    private int rating;
    private String comment;
    private LocalDateTime reviewDate;
}
