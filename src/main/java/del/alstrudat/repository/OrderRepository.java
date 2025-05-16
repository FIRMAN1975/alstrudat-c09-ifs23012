package del.alstrudat.repository;

import del.alstrudat.entity.*;
import java.util.*;

public interface OrderRepository {
    void addOrder(Order order);
    Order getOrderById(String id);
    void updateOrder(Order order);
    void deleteOrder(String id);
    List<Order> getOrdersByBuyer(String buyerUsername);
}