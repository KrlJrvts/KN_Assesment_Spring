package com.example.order_managment_system.business.orders;

import com.example.order_managment_system.business.orders.dtos.OrderByDateResponse;
import com.example.order_managment_system.business.orders.dtos.OrderByProductResponse;
import com.example.order_managment_system.business.orders.dtos.OrderCreateRequest;
import com.example.order_managment_system.business.orders.dtos.OrderLinesCreateRequest;
import com.example.order_managment_system.domain.product.Product;
import com.example.order_managment_system.domain.product.ProductService;
import com.example.order_managment_system.domain.user.UserService;
import com.example.order_managment_system.domain.user.order.Order;
import com.example.order_managment_system.domain.user.order.OrderMapper;
import com.example.order_managment_system.domain.user.order.OrderService;
import com.example.order_managment_system.domain.user.orderline.OrderLine;
import com.example.order_managment_system.domain.user.orderline.OrderLineMapper;
import com.example.order_managment_system.domain.user.orderline.OrderLineService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersService {

    @Resource
    private OrderService orderService;

    @Resource
    private UserService userService;

    @Resource
    private ProductService productService;

    @Resource
    private OrderLineService orderLineService;

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private OrderLineMapper orderLineMapper;


    public List<OrderByDateResponse> getOrdersByDate(LocalDate date) {
        List<Order> orders = orderService.getOrders(date);
        return orderMapper.toOrderByDateResponseList(orders);
    }

    public List<OrderByProductResponse> getOrdersByProduct(Integer productId) {
        List<OrderLine> orders = orderLineService.getOrdersByProduct(productId);
        return orderLineMapper.toOrderByProductResponseList(orders);
    }


    public void createOrder(OrderCreateRequest orderCreateRequest) {
        LocalDate submissionDate = orderCreateRequest.getSubmissionDate();
        Integer user = orderCreateRequest.getUserId();

        // Create the order and set its properties
        Order order = new Order();
        order.setSubmissionDate(submissionDate);
        order.setUser(userService.getUserById(user));

        // Save the order and obtain the generated orderId
        Integer orderId = orderService.createOrder(order);

        List<OrderLine> orderLines = createOrderLines(orderCreateRequest.getOrderLines(), orderId);
        orderLineService.saveOrderLines(orderLines);
    }

    private List<OrderLine> createOrderLines(List<OrderLinesCreateRequest> orderLinesCreateRequests, Integer orderId) {
        List<OrderLine> orderLines = new ArrayList<>();

        for (OrderLinesCreateRequest orderLineCreateRequest : orderLinesCreateRequests) {
            OrderLine orderLine = orderLineMapper.toOrderLine(orderLineCreateRequest);

            // Create a new instance of OrderLine and set its properties
            OrderLine newOrderLine = new OrderLine();
            newOrderLine.setQuantity(orderLine.getQuantity());
            newOrderLine.setOrders(orderService.getOrderById(orderId)); // Set the orders property

            // Set the products property
            Product product = productService.getProductById(orderLineCreateRequest.getProductId());
            newOrderLine.setProducts(product);

            orderLines.add(newOrderLine);
        }

        return orderLines;
    }



}


