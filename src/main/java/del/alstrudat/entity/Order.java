package del.alstrudat.entity;
import java.util.*;

public class Order {
    private final String id;
    private final String buyerUsername;
    private final List<Product> products;
    private final boolean paid;

    public Order(String id, String buyerUsername, List<Product> products, boolean paid) {
        validateString(id, "ID");
        validateString(buyerUsername, "Buyer username");
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Produk tidak valid: tidak boleh null atau kosong.");
        }
        this.id = id;
        this.buyerUsername = buyerUsername;
        this.products = new ArrayList<>(products);
        this.paid = paid;
    }

    public String getId() {
        return id;
    }

    public String getBuyerUsername() {
        return buyerUsername;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getTotal() {
        return calculateTotal();
    }

    public double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Order{id='" + id + "', buyerUsername='" + buyerUsername + "', products=" + products.size() + ", paid=" + paid + "}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}