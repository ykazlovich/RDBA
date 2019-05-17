package com.rdba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdba.model.jpa.order.Order;
import com.rdba.repository.OrderRepository;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> getAllOrder() {
        List<Order> orders = repository.getAllOrder();
        orders.sort((o1, o2) -> o1.getId() > o2.getId() ? -1 : 0);
        return orders;
    }

    @Override
    public Order getOrder(int id) {
        return repository.getOrder(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return repository.saveOrder(order);
    }
}
