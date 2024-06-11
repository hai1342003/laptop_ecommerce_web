package com.example.ecommerce.laptop_ecommerce_platform.service;

import com.example.ecommerce.laptop_ecommerce_platform.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(ReviewDto reviewDto);


    ReviewDto getReviewById(Long reviewId);

    ReviewDto getReviewByLaptopId(Long laptopId);

    List<ReviewDto> getAllReviews();

    ReviewDto updateReview(Long reviewId, ReviewDto updatedReview);

    void deleteReview(Long reviewId);
}
