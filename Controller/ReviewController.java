package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Review;
import com.example.demo.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    // Create Review
    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    // Get All Reviews
    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    // Get Reviews by Rating
    @GetMapping("/rating/{rating}")
    public List<Review> getReviewsByRating(@PathVariable int rating) {
        return reviewService.getReviewsByRating(rating);
    }

    // Update Review by ID
    @PutMapping("/{id}")
    public Review updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        return reviewService.updateReview(id, updatedReview);
    }

    // Delete Review by ID
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return "Review with ID " + id + " has been deleted.";
    }
}
