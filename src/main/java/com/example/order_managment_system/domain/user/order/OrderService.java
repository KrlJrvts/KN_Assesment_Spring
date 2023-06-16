package com.example.order_managment_system.domain.user.order;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;


    public List<Order> getOrders(LocalDate date) {

        return orderRepository.findAllBy(date);
    }

    public Integer createOrder(Order order) {
        orderRepository.save(order);
        return order.getId();
    }

    public Order getOrderById(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }

    public List<Order> getOrdersByUser(Integer userId) {
        return orderRepository.getOrdersByUser(userId);
    }
}

