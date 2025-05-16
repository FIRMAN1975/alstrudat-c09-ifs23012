package del.alstrudat.repository;
import del.alstrudat.entity.*;
import java.util.*;


public interface ReviewRepository {
    void addReview(Review review);
    List<Review> getReviewsByProductId(String productId);
    void deleteReview(String productId, String buyerUsername, String comment);
}