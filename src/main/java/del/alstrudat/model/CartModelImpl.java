package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class CartModelImpl implements CartModel {
    private final CartRepository cartRepository;
    private final ProductModel productModel;

    public CartModelImpl(CartRepository cartRepository, ProductModel productModel) {
        this.cartRepository = cartRepository;
        this.productModel = productModel;
    }

    @Override
    public void addToCart(String username, String productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Jumlah tidak valid: harus lebih dari 0.");
        }
        Product product = productModel.getProduct(productId);
        if (product == null) {
            throw new IllegalArgumentException("Produk tidak ditemukan.");
        }
        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Stok tidak cukup.");
        }
        Cart cart = getCart(username);
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();
        if (existingItem.isPresent()) {
            cart.getItems().remove(existingItem.get());
            cart.getItems().add(new CartItem(productId, existingItem.get().getQuantity() + quantity));
        } else {
            cart.getItems().add(new CartItem(productId, quantity));
        }
        productModel.updateStock(productId, product.getStock() - quantity);
        cartRepository.updateCart(username, cart);
    }

    @Override
    public Cart getCart(String username) {
        Cart cart = cartRepository.getCartByUsername(username);
        if (cart == null) {
            cart = new Cart();
            cartRepository.addCart(username, cart);
        }
        return cart;
    }

    @Override
    public void removeFromCart(String username, String productId) {
        Cart cart = getCart(username);
        CartItem itemToRemove = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Item tidak ditemukan di keranjang."));
        cart.getItems().remove(itemToRemove);
        Product product = productModel.getProduct(productId);
        if (product != null) {
            productModel.updateStock(productId, product.getStock() + itemToRemove.getQuantity());
        }
        cartRepository.updateCart(username, cart);
    }

    @Override
    public void clearCart(String username) {
        Cart cart = getCart(username);
        for (CartItem item : cart.getItems()) {
            Product product = productModel.getProduct(item.getProductId());
            if (product != null) {
                productModel.updateStock(item.getProductId(), product.getStock() + item.getQuantity());
            }
        }
        cart.getItems().clear();
        cartRepository.updateCart(username, cart);
    }

    @Override
    public String toString() {
        return "CartModelImpl{cartRepository=" + cartRepository + "}";
    }
}