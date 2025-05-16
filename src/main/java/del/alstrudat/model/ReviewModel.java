package del.alstrudat.model;

import del.alstrudat.entity.*;
import java.util.*;

public interface ReviewModel {
    void addReview(String productId, Product product, String buyerUsername, int rating, String comment);
    List<Review> getReviews(String productId);
}