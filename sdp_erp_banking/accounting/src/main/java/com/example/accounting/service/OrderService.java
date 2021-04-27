package com.example.accounting.service;

import com.example.accounting.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    void saveOrder(Order order);

    Order getOrderById(long id);

    void deleteOrderById(long id);
}
