package com.rdba.web.controller;

import com.rdba.model.jpa.order.Order;
import com.rdba.service.OrderService;
import com.rdba.util.ValidationUtil;
import com.rdba.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin()
@RequestMapping(value = "/v1/orders")
public class OrderRestController {


    @Autowired
    OrderService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Order> getAllOrder() {
        return service.getAllOrder();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order addedOrder = service.saveOrder(order);
        ResponseEntity<Order> o = new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
        return o;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order getById(@PathVariable int id) {
        Order order = service.getOrder(id);
        ValidationUtil.checkNotFoundWithId(order, id);
        return order;
    }


}
