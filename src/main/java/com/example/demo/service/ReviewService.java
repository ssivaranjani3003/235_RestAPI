package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Review;
import com.example.demo.Repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    
    // Create Review
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    // Get All Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get Reviews by Rating
    public List<Review> getReviewsByRating(int rating) {
        return reviewRepository.findReviewsByRating(rating);
    }

    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }
    

    // Delete Review
    public void deleteReview(Long id) {
        reviewRepository.findById(id).ifPresentOrElse(
            review -> reviewRepository.delete(review),
            () -> { throw new IllegalArgumentException("Review with ID " + id + " not found."); }
        );
    }

    // Update Review
    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepository.findById(id).map(existingReview -> {
            updatedReview.setId(id);
            return reviewRepository.save(updatedReview);
        }).orElseThrow(() -> new IllegalArgumentException("Review with ID " + id + " not found."));
    }
}
