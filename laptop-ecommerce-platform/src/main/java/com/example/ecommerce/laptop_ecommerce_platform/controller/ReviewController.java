package com.example.ecommerce.laptop_ecommerce_platform.controller;

import com.example.ecommerce.laptop_ecommerce_platform.dto.ReviewDto;
import com.example.ecommerce.laptop_ecommerce_platform.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        ReviewDto savedReview = reviewService.createReview(reviewDto);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable("id") Long reviewId) {
        ReviewDto reviewDto = reviewService.getReviewById(reviewId);
        return ResponseEntity.ok(reviewDto);
    }

    @GetMapping("laptop/{laptop_id}")
    public ResponseEntity<ReviewDto> getReviewByLaptopId(@PathVariable("laptop_id") Long laptopId) {
        ReviewDto reviewDtos = reviewService.getReviewByLaptopId(laptopId);
        return ResponseEntity.ok(reviewDtos);
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        List<ReviewDto> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable("id") Long reviewId,
                                                  @RequestBody ReviewDto updatedReview) {
        ReviewDto reviewDto = reviewService.updateReview(reviewId, updatedReview);
        return ResponseEntity.ok(reviewDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReview(@PathVariable("id") Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.ok("Review deleted successfully!");
    }
}