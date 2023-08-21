package dev.ricky.movie.controller;


import dev.ricky.movie.domain.Review;
import dev.ricky.movie.service.ReviewService;
import dev.ricky.movie.service.dto.CreateReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/create")
    private ResponseEntity<Review> createReview(@RequestBody CreateReviewDTO createReviewDTO){
        return ResponseEntity.ok(reviewService.createReview(createReviewDTO));
    }
}
