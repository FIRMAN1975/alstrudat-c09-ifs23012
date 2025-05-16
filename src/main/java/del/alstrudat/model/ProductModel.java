package del.alstrudat.model;

import del.alstrudat.entity.*;
import java.util.*;

public interface ProductModel {
    void addProduct(String id, String name, double price, int stock, String sellerUsername, String categoryId);
    Product getProduct(String id);
    void updateProduct(String id, String name, double price, int stock, String categoryId);
    void updateStock(String id, int newStock);
    void deleteProduct(String id);
    List<Product> getAllProducts();
    List<Product> getProductsBySeller(String sellerUsername);
    List<Product> getProductsByCategory(String categoryId);
}
