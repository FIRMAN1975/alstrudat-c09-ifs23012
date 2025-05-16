package del.alstrudat.repository;
import del.alstrudat.entity.*;
import java.util.*;
import java.util.stream.Collectors;


public class ProductRepositoryImpl implements ProductRepository {
    private final Map<String, Product> products;

    public ProductRepositoryImpl() {
        this.products = new TreeMap<>();
    }

    @Override
    public void addProduct(Product product) {
        validateProduct(product);
        if (products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Produk sudah ada.");
        }
        products.put(product.getId(), product);
    }

    @Override
    public Product getProductById(String id) {
        validateString(id, "ID");
        return products.get(id);
    }

    @Override
    public void updateProduct(Product product) {
        validateProduct(product);
        if (!products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Produk tidak ditemukan.");
        }
        products.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(String id) {
        validateString(id, "ID");
        if (products.remove(id) == null) {
            throw new IllegalArgumentException("Produk tidak ditemukan.");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public List<Product> getProductsBySeller(String sellerUsername) {
        validateString(sellerUsername, "Seller username");
        return products.values().stream()
                .filter(p -> p.getSellerUsername().equals(sellerUsername))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        validateString(categoryId, "Category ID");
        return products.values().stream()
                .filter(p -> p.getCategoryId().equals(categoryId))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ProductRepositoryImpl{products=" + products.size() + "}";
    }

    private void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Produk tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}