package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;
import java.util.stream.Collectors;


public class OrderRepositoryImpl implements OrderRepository {
    private final Map<String, Order> orders;

    public OrderRepositoryImpl() {
        this.orders = new HashMap<>();
    }

    @Override
    public void addOrder(Order order) {
        validateOrder(order);
        if (orders.containsKey(order.getId())) {
            throw new IllegalArgumentException("Pesanan sudah ada.");
        }
        orders.put(order.getId(), order);
    }

    @Override
    public Order getOrderById(String id) {
        validateString(id, "ID");
        return orders.get(id);
    }

    @Override
    public void updateOrder(Order order) {
        validateOrder(order);
        if (!orders.containsKey(order.getId())) {
            throw new IllegalArgumentException("Pesanan tidak ditemukan.");
        }
        orders.put(order.getId(), order);
    }

    @Override
    public void deleteOrder(String id) {
        validateString(id, "ID");
        if (orders.remove(id) == null) {
            throw new IllegalArgumentException("Pesanan tidak ditemukan.");
        }
    }

    @Override
    public List<Order> getOrdersByBuyer(String buyerUsername) {
        validateString(buyerUsername, "Buyer username");
        return orders.values().stream()
                .filter(o -> o.getBuyerUsername().equals(buyerUsername))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "OrderRepositoryImpl{orders=" + orders.size() + "}";
    }

    private void validateOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Pesanan tidak valid: tidak boleh null.");
        }
    }

    private void validateString(String value, String field) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " tidak valid: tidak boleh null atau kosong.");
        }
    }
}