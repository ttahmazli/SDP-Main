package com.example.accounting.service;

import com.example.accounting.model.Order;
import com.example.accounting.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {

        this.orderRepository.save(order);
    }

    @Override
    public Order getOrderById(long id) {

        Optional<Order> optional = this.orderRepository.findById(id);
        Order order = null;

        if (optional.isPresent())
            order = optional.get();
        else
            throw new RuntimeException("Order couldn't be found with given ID: " + id);

        return order;
    }

    @Override
    public void deleteOrderById(long id) {

        this.orderRepository.deleteById(id);
    }
}
