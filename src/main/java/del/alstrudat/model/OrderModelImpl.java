package del.alstrudat.model;

import del.alstrudat.entity.*;
import del.alstrudat.repository.*;
import java.util.*;

public class OrderModelImpl implements OrderModel {
    private final OrderRepository orderRepository;

    public OrderModelImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(String id, String buyerUsername, List<Product> products, boolean paid) {
        orderRepository.addOrder(new Order(id, buyerUsername, products, paid));
    }

    @Override
    public Order getOrder(String id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<Order> getOrdersByBuyer(String buyerUsername) {
        return orderRepository.getOrdersByBuyer(buyerUsername);
    }

    @Override
    public String toString() {
        return "OrderModelImpl{orderRepository=" + orderRepository + "}";
    }
}