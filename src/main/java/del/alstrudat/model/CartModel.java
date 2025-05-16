package del.alstrudat.model;

import del.alstrudat.entity.*;

public interface CartModel {
    void addToCart(String username, String productId, int quantity);
    Cart getCart(String username);
    void removeFromCart(String username, String productId);
    void clearCart(String username);
}