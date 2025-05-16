package del.alstrudat.entity;

public class Review {
    private final String productId;
    private final Product product;
    private final String buyerUsername;
    private final int rating;
    private final String comment;

    public Review(String productId, Product product, String buyerUsername, int rating, String comment) {
        validateString(productId, "Product ID");
        if (product == null) {
            throw new IllegalArgumentException("Produk tidak valid: tidak boleh null.");
        }
        validateString(buyerUsername, "Buyer username");
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating tidak valid: harus antara 1 dan 5.");
        }
        validateString(comment, "Comment");
        this.productId = productId;
        this.product = product;
        this.buyerUsername = buyerUsername;
        this.rating = rating;
        this.comment = comment;
    }

    public String getProductId() {
        return productId;
    }

    public Product getProduct() {
        return product;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Review{productId='" + productId + "', buyerUsername='" + buyerUsername + "', rating=" + rating + ", comment='" + comment + "'}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}