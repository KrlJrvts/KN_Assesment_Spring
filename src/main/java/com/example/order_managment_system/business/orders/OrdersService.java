package com.example.order_managment_system.business.orders;

import com.example.order_managment_system.business.orders.dtos.OrderByDateResponse;
import com.example.order_managment_system.domain.user.order.Order;
import com.example.order_managment_system.domain.user.order.OrderMapper;
import com.example.order_managment_system.domain.user.order.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersService {

    @Resource
    private OrderService orderService;

    @Resource
    private OrderMapper orderMapper;

    public List<OrderByDateResponse> getOrdersBy(LocalDate date) {
        List<Order> orders = orderService.getOrders(date);
        return orderMapper.toOrderByDateResponseList(orders);
    }

}
