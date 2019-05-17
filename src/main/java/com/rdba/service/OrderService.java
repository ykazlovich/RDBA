package com.rdba.service;

import com.rdba.model.jpa.order.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder();

    Order getOrder(int id);

    Order saveOrder(Order order);
}
