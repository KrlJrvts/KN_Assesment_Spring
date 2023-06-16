package com.example.order_managment_system.business.orders;

import com.example.order_managment_system.business.orders.dtos.*;
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
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<OrderByUserResponse> getOrdersByUser(Integer userId) {
        List<Order> orders = orderService.getOrdersByUser(userId);
        List<OrderByUserResponse> orderResponses = new ArrayList<>();

        for (Order order : orders) {
            OrderByUserResponse orderByUserResponse = getOrderByUserResponse(order);

            List<OrderLine> orderLines = orderLineService.getOrderLinesByUser(userId);
            List<OrderLinesByUserResponse> orderLinesResponses = new ArrayList<>();

            for (OrderLine orderLine : orderLines) {
                if (Objects.equals(orderLine.getOrders().getId(), order.getId())) {
                    OrderLinesByUserResponse orderLineResponse = getOrderLinesByUserResponse(orderLine);
                    orderLinesResponses.add(orderLineResponse);
                }
            }

            orderByUserResponse.setOrderLines(orderLinesResponses);
            orderResponses.add(orderByUserResponse);
        }

        return orderResponses;
    }



    public void createOrder(OrderCreateRequest orderCreateRequest) {
        LocalDate submissionDate = orderCreateRequest.getSubmissionDate();
        Integer user = orderCreateRequest.getUserId();
        Order order = getOrder(submissionDate, user);
        Integer orderId = orderService.createOrder(order);
        List<OrderLine> orderLines = createOrderLines(orderCreateRequest.getOrderLines(), orderId);
        orderLineService.saveOrderLines(orderLines);
    }

    private static OrderByUserResponse getOrderByUserResponse(Order order) {
        OrderByUserResponse orderByUserResponse = new OrderByUserResponse();
        orderByUserResponse.setId(order.getId());
        orderByUserResponse.setFullName(order.getUser().getFullName());
        return orderByUserResponse;
    }

    private static OrderLinesByUserResponse getOrderLinesByUserResponse(OrderLine orderLine) {
        OrderLinesByUserResponse orderLineResponse = new OrderLinesByUserResponse();
        orderLineResponse.setOrderId(orderLine.getOrders().getId());
        orderLineResponse.setProductName(orderLine.getProducts().getName());
        orderLineResponse.setQuantity(orderLine.getQuantity());
        orderLineResponse.setPrice(orderLine.getProducts().getUnitPrice());
        orderLineResponse.setSkuCode(orderLine.getProducts().getSkuCode());
        return orderLineResponse;
    }

    private Order getOrder(LocalDate submissionDate, Integer user) {
        Order order = new Order();
        order.setSubmissionDate(submissionDate);
        order.setUser(userService.getUserById(user));
        return order;
    }

    private List<OrderLine> createOrderLines(List<OrderLinesCreateRequest> orderLinesCreateRequests, Integer orderId) {
        List<OrderLine> orderLines = new ArrayList<>();

        for (OrderLinesCreateRequest orderLineCreateRequest : orderLinesCreateRequests) {
            OrderLine orderLine = orderLineMapper.toOrderLine(orderLineCreateRequest);

            OrderLine newOrderLine = new OrderLine();
            newOrderLine.setQuantity(orderLine.getQuantity());
            newOrderLine.setOrders(orderService.getOrderById(orderId)); // Set the orders property

            Product product = productService.getProductById(orderLineCreateRequest.getProductId());
            newOrderLine.setProducts(product);
            orderLines.add(newOrderLine);
        }
        return orderLines;
    }

    public void updateOrder(Integer orderId, OrderLineQuantityEditRequest orderLineQuantityEditRequest) {
        Integer orderLineNo = orderLineQuantityEditRequest.getOrderLineNo();
        Integer quantity = orderLineQuantityEditRequest.getQuantity();
        orderLineService.updateOrderLine(orderId, orderLineNo, quantity);
    }
}


