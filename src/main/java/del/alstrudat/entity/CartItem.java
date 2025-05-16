package del.alstrudat.entity;
public class CartItem {
    private final String productId;
    private final int quantity;

    public CartItem(String productId, int quantity) {
        validateString(productId, "Product ID");
        if (quantity <= 0) {
            throw new IllegalArgumentException("Jumlah tidak valid: harus lebih dari 0.");
        }
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "CartItem{productId='" + productId + "', quantity=" + quantity + "}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}