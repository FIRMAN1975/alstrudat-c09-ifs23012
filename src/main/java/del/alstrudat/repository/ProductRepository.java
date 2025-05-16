package del.alstrudat.repository;
import del.alstrudat.entity.*;
import java.util.*;


public interface ProductRepository {
    void addProduct(Product product);
    Product getProductById(String id);
    void updateProduct(Product product);
    void deleteProduct(String id);
    List<Product> getAllProducts();
    List<Product> getProductsBySeller(String sellerUsername);
    List<Product> getProductsByCategory(String categoryId);
}