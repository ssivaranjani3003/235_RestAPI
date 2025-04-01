package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // JPQL query to find reviews by rating
    @Query("SELECT r FROM Review r WHERE r.rating = :rating")
    List<Review> findReviewsByRating(@Param("rating") int rating);
}
