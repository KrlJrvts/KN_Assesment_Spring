package com.example.order_managment_system.domain.user.orderline;

import com.example.order_managment_system.business.orders.dtos.OrderLinesCreateRequest;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderLineService {

    @Resource
    private OrderLineRepository orderLineRepository;

    @Resource
    private OrderLineMapper orderLineMapper;



    public void addAll(List<OrderLinesCreateRequest> orderLinesCreateRequests) {
        List<OrderLine> orderLines = orderLineMapper.toOrderLineList(orderLinesCreateRequests);
        orderLineRepository.saveAll(orderLines);
    }

    public void saveOrderLines(List<OrderLine> orderLines) {
        orderLineRepository.saveAll(orderLines);
    }
}
