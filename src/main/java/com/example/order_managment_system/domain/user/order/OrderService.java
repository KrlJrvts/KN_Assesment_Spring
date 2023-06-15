package com.example.order_managment_system.domain.user.order;

import com.example.order_managment_system.domain.user.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;


    public List<Order> getOrders(LocalDate date) {
        return orderRepository.findAllBy(date);
    }
}

