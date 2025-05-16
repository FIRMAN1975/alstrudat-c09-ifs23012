package del.alstrudat.model;

import del.alstrudat.entity.*;
import java.util.*;

public interface OrderModel {
    void createOrder(String id, String buyerUsername, List<Product> products, boolean paid);
    Order getOrder(String id);
    List<Order> getOrdersByBuyer(String buyerUsername);
}