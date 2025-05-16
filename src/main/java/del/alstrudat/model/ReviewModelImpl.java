package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class ReviewModelImpl implements ReviewModel {
    private final ReviewRepository reviewRepository;

    public ReviewModelImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void addReview(String productId, Product product, String buyerUsername, int rating, String comment) {
        reviewRepository.addReview(new Review(productId, product, buyerUsername, rating, comment));
    }

    @Override
    public List<Review> getReviews(String productId) {
        return reviewRepository.getReviewsByProductId(productId);
    }

    @Override
    public String toString() {
        return "ReviewModelImpl{reviewRepository=" + reviewRepository + "}";
    }
}