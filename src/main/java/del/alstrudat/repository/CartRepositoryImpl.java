package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;

public class CartRepositoryImpl implements CartRepository {
    private final Map<String, Cart> carts;

    public CartRepositoryImpl() {
        this.carts = new HashMap<>();
    }

    @Override
    public void addCart(String username, Cart cart) {
        validateCart(cart);
        validateString(username, "Username");
        carts.put(username, cart);
    }

    @Override
    public Cart getCartByUsername(String username) {
        validateString(username, "Username");
        return carts.get(username);
    }

    @Override
    public void updateCart(String username, Cart cart) {
        validateCart(cart);
        validateString(username, "Username");
        carts.put(username, cart);
    }

    @Override
    public void deleteCart(String username) {
        validateString(username, "Username");
        carts.remove(username);
    }

    @Override
    public String toString() {
        return "CartRepositoryImpl{carts=" + carts.size() + "}";
    }

    private void validateCart(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Keranjang tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}