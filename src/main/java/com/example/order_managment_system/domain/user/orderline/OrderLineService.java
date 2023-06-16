package com.example.order_managment_system.domain.user.orderline;

import com.example.order_managment_system.business.orders.dtos.OrderByUserResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    @Resource
    private OrderLineRepository orderLineRepository;

    @Resource
    private OrderLineMapper orderLineMapper;


    public void saveOrderLines(List<OrderLine> orderLines) {
        orderLineRepository.saveAll(orderLines);
    }

    public List<OrderLine> getOrdersByProduct(Integer productId) {
        return orderLineRepository.getOrdersByProduct(productId);
    }

    public List<OrderByUserResponse> getOrdersByUser(Integer userId) {
        List<OrderLine> orders = orderLineRepository.getOrdersByUser(userId);
        return orderLineMapper.toOrderByUserResponseList(orders);
    }
}

