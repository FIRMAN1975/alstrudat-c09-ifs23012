package del.alstrudat.repository;

import del.alstrudat.entity.*;

public interface CartRepository {
    void addCart(String username, Cart cart);
    Cart getCartByUsername(String username);
    void updateCart(String username, Cart cart);
    void deleteCart(String username);
}