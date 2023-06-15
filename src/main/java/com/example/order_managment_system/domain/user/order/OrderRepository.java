package com.example.order_managment_system.domain.user.order;

import com.example.order_managment_system.domain.user.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}