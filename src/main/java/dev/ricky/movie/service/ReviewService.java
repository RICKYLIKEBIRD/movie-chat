package dev.ricky.movie.service;

import com.mongodb.client.result.UpdateResult;
import dev.ricky.movie.domain.Movie;
import dev.ricky.movie.domain.Review;
import dev.ricky.movie.repository.ReviewRepository;
import dev.ricky.movie.service.dto.CreateReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(CreateReviewDTO createReviewDTO){
        Review review = reviewRepository.insert( new Review(createReviewDTO.getReviewBody()));

        updateReviewRelativeByImdbId(review, createReviewDTO.getImdbId());

        return review;
    }

    public void updateReviewRelativeByImdbId(Review review,String imdbId){
        UpdateResult updateResult = mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        System.out.println("show update result = " +updateResult);
    }
}
