package del.alstrudat.entity;
import java.util.*;

public class Cart {
    private final List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Cart{items=" + items.size() + "}";
    }
}