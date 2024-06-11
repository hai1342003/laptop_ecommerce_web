package com.example.ecommerce.laptop_ecommerce_platform.mapper;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.ReviewDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.UserDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Review;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;

public class ReviewMapper {
    public static ReviewDto mapToReviewDto(Review review) {
        return new ReviewDto(
                review.getId(),
                new LaptopDto(
                        review.getLaptop().getId(),
                        review.getLaptop().getName(),
                        review.getLaptop().getBrand(),
                        review.getLaptop().getDescription(),
                        review.getLaptop().getPrice(),
                        review.getLaptop().getQuantity(),
                        review.getLaptop().getProcessor(),
                        review.getLaptop().getRamSize(),
                        review.getLaptop().getStorage(),
                        review.getLaptop().getGraphicsCard(),
                        review.getLaptop().getDisplay()
                ),
                new UserDto(
                        review.getUser().getId(),
                        review.getUser().getUsername(),
                        review.getUser().getRole()
                ),
                review.getRating(),
                review.getComment(),
                review.getReviewDate()
        );
    }

    public static Review mapToReview(ReviewDto reviewDto) {
        return new Review(
                reviewDto.getId(),
                new Laptop(
                        reviewDto.getLaptop().getId(),
                        reviewDto.getLaptop().getName(),
                        reviewDto.getLaptop().getBrand(),
                        reviewDto.getLaptop().getDescription(),
                        reviewDto.getLaptop().getPrice(),
                        reviewDto.getLaptop().getQuantity(),
                        reviewDto.getLaptop().getProcessor(),
                        reviewDto.getLaptop().getRamSize(),
                        reviewDto.getLaptop().getStorage(),
                        reviewDto.getLaptop().getGraphicsCard(),
                        reviewDto.getLaptop().getDisplay()
                ),
                new User(
                        reviewDto.getUser().getId(),
                        reviewDto.getUser().getName(),
                        reviewDto.getUser().getRole()
                ),
                reviewDto.getRating(),
                reviewDto.getComment(),
                reviewDto.getReviewDate()
        );
    }
}
