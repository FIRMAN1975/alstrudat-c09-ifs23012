package del.alstrudat.entity;

public class Product {
    private final String id;
    private String name;
    private double price;
    private int stock;
    private final String sellerUsername;
    private String categoryId;

    public Product(String id, String name, double price, int stock, String sellerUsername, String categoryId) {
        validateString(id, "ID");
        validateString(name, "Name");
        if (price < 0) {
            throw new IllegalArgumentException("Harga tidak valid: tidak boleh negatif.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stok tidak valid: tidak boleh negatif.");
        }
        validateString(sellerUsername, "Seller username");
        validateString(categoryId, "Category ID");
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sellerUsername = sellerUsername;
        this.categoryId = categoryId;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setName(String name) {
        validateString(name, "Name");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Harga tidak valid: tidak boleh negatif.");
        }
        this.price = price;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stok tidak valid: tidak boleh negatif.");
        }
        this.stock = stock;
    }

    public void setCategoryId(String categoryId) {
        validateString(categoryId, "Category ID");
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name + "', price=" + price + ", stock=" + stock + ", sellerUsername='" + sellerUsername + "', categoryId='" + categoryId + "'}";
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}