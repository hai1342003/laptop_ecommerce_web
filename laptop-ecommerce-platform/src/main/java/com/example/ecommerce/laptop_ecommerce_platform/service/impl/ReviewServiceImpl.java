package com.example.ecommerce.laptop_ecommerce_platform.service.impl;

import com.example.ecommerce.laptop_ecommerce_platform.dto.LaptopDto;
import com.example.ecommerce.laptop_ecommerce_platform.dto.ReviewDto;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Laptop;
import com.example.ecommerce.laptop_ecommerce_platform.entity.Review;
import com.example.ecommerce.laptop_ecommerce_platform.entity.User;
import com.example.ecommerce.laptop_ecommerce_platform.exception.ResourceNotFoundException;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.LaptopMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.ReviewMapper;
import com.example.ecommerce.laptop_ecommerce_platform.mapper.UserMapper;
import com.example.ecommerce.laptop_ecommerce_platform.repository.LaptopRepository;
import com.example.ecommerce.laptop_ecommerce_platform.repository.ReviewRepository;
import com.example.ecommerce.laptop_ecommerce_platform.service.LaptopService;
import com.example.ecommerce.laptop_ecommerce_platform.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {


    private ReviewRepository reviewRepository;


    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        Review review = ReviewMapper.mapToReview(reviewDto);
        Review savedReview = reviewRepository.save(review);
        return ReviewMapper.mapToReviewDto(savedReview);
    }

    @Override
    public ReviewDto getReviewById(Long reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Review is not exists with given id: " + reviewId));

        return ReviewMapper.mapToReviewDto(review);
    }

    @Override
    public ReviewDto getReviewByLaptopId(Long laptopId) {
        Review review = reviewRepository.findByLaptopId(laptopId);

        return ReviewMapper.mapToReviewDto(review);
    }
    @Override
    public List<ReviewDto> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map((review) -> ReviewMapper.mapToReviewDto(review))
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDto updateReview(Long reviewId, ReviewDto updatedReview) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new ResourceNotFoundException("Review is not exists with given id" + reviewId)
        );

        review.setLaptop(review.getLaptop());
        review.setUser(review.getUser());
        review.setRating(review.getRating());
        review.setComment(review.getComment());
        review.setReviewDate(review.getReviewDate());


        Review updatedReviewObj = reviewRepository.save(review);

        return ReviewMapper.mapToReviewDto(updatedReviewObj);
    }

    @Override
    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new ResourceNotFoundException("Review is not exists with given id" + reviewId)
        );

        reviewRepository.deleteById(reviewId);
    }
}
