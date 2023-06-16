package com.example.order_managment_system.domain.user.orderline;

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

    public List<OrderLine> getOrderLinesByUser(Integer userId) {
        return orderLineRepository.getOrderLinesByUser(userId);

    }

    public void updateOrderLine(Integer orderId, Integer quantity, Integer orderLineNo) {
        List<OrderLine> orderLines = orderLineRepository.getOrderBy(orderId);


        int numberOfOrderLines = orderLines.size();

        if (orderLineNo <= numberOfOrderLines) {
            OrderLine orderLine = orderLines.get(orderLineNo);
            orderLine.setQuantity(quantity);
            orderLineRepository.save(orderLine);


        }

        //             throw new RuntimeException("Order line number is not valid");






//        for (OrderLine orderLine : orderLines) {
//            if (orderLines.size().equals(orderLineNo) {
//                orderLine.setQuantity(quantity);
//                orderLineRepository.save(orderLine);
//                break;
//            }
//        }
    }

}

