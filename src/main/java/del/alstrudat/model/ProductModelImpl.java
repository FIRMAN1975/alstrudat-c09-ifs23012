package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class ProductModelImpl implements ProductModel {
    private final ProductRepository productRepository;

    public ProductModelImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(String id, String name, double price, int stock, String sellerUsername, String categoryId) {
        productRepository.addProduct(new Product(id, name, price, stock, sellerUsername, categoryId));
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.getProductById(id);
    }

    @Override
    public void updateProduct(String id, String name, double price, int stock, String categoryId) {
        Product product = getProduct(id);
        if (product == null) {
            throw new IllegalArgumentException("Produk tidak ditemukan.");
        }
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setCategoryId(categoryId);
        productRepository.updateProduct(product);
    }

    @Override
    public void updateStock(String id, int newStock) {
        Product product = getProduct(id);
        if (product == null) {
            throw new IllegalArgumentException("Produk tidak ditemukan.");
        }
        product.setStock(newStock);
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public List<Product> getProductsBySeller(String sellerUsername) {
        return productRepository.getProductsBySeller(sellerUsername);
    }

    @Override
    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.getProductsByCategory(categoryId);
    }

    @Override
    public String toString() {
        return "ProductModelImpl{productRepository=" + productRepository + "}";
    }
}