package com.rdba.repository;

import com.rdba.model.jpa.order.Order;

import java.util.List;

public interface OrderRepository {
    Order getOrder(int orderId);

    Order saveOrder(Order order);

    void deleteOrder(Order order);

   List<Order> getAllOrder();

}
