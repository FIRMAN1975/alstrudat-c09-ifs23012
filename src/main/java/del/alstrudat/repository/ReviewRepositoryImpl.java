package del.alstrudat.repository;
import del.alstrudat.entity.*;
import java.util.*;


public class ReviewRepositoryImpl implements ReviewRepository {
    private final Map<String, List<Review>> reviews;

    public ReviewRepositoryImpl() {
        this.reviews = new HashMap<>();
    }

    @Override
    public void addReview(Review review) {
        validateReview(review);
        List<Review> productReviews = reviews.computeIfAbsent(review.getProductId(), k -> new ArrayList<>());
        productReviews.add(review);
    }

    @Override
    public List<Review> getReviewsByProductId(String productId) {
        validateString(productId, "Product ID");
        return reviews.getOrDefault(productId, new ArrayList<>());
    }

    @Override
    public void deleteReview(String productId, String buyerUsername, String comment) {
        validateString(productId, "Product ID");
        validateString(buyerUsername, "Buyer username");
        validateString(comment, "Comment");
        List<Review> productReviews = reviews.get(productId);
        if (productReviews != null) {
            productReviews.removeIf(r -> r.getBuyerUsername().equals(buyerUsername) && r.getComment().equals(comment));
            if (productReviews.isEmpty()) {
                reviews.remove(productId);
            }
        }
    }

    @Override
    public String toString() {
        return "ReviewRepositoryImpl{reviews=" + reviews.size() + "}";
    }

    private void validateReview(Review review) {
        if (review == null) {
            throw new IllegalArgumentException("Ulasan tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}