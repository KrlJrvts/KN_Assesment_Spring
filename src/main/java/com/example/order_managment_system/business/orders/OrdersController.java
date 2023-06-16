package com.example.order_managment_system.business.orders;

import com.example.order_managment_system.business.orders.dtos.*;
import com.example.order_managment_system.domain.user.UserService;
import com.example.order_managment_system.domain.user.orderline.OrderLineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @Resource
    private OrderLineService orderLineService;

    @Resource
    private UserService userService;


    @GetMapping("/by-date")
    @Operation(summary = "Get all orders", description = "Get all orders by entering date in format yyyy-mm-dd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders found successfully!"),
            @ApiResponse(responseCode = "403", description = "Orders not found!")})
    public List<OrderByDateResponse> getOrders(@RequestParam LocalDate date) {

        return ordersService.getOrdersByDate(date);
    }

    @GetMapping("/by-product")
    @Operation(summary = "Get all orders", description = "Get all orders by entering productId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders found successfully!"),
            @ApiResponse(responseCode = "403", description = "Orders not found!")})
    public List<OrderByProductResponse> getOrdersByProduct(@RequestParam Integer productId) {

        return ordersService.getOrdersByProduct(productId);
    }

    @GetMapping("/by-user")
    @Operation(summary = "Get all orders", description = "Get all orders by entering userId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders found successfully!"),
            @ApiResponse(responseCode = "403", description = "Orders not found!")})
    public List<OrderByUserResponse> getOrdersByUser(@RequestParam Integer userId) {
        return ordersService.getOrdersByUser(userId);
    }

    @PostMapping("/create")
    @Operation(summary = "Create a new order",
            description = "by creating first order line with requested userId and submission date and adding items  by itemId and quantity into the orderLine database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created successfully!"),
            @ApiResponse(responseCode = "403", description = "Order creation failed!")})
    public void createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        ordersService.createOrder(orderCreateRequest);
    }

    @PatchMapping("/update")
    @Operation(summary = "Update an order item quantity",
            description = "by updating quantity of items in orderLine database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order updated successfully!"),
            @ApiResponse(responseCode = "403", description = "Order update failed!")})
    public void updateOrder(@RequestParam Integer orderId,  @RequestBody OrderLineQuantityEditRequest orderLineQuantityEditRequest) {
        ordersService.updateOrder(orderId, orderLineQuantityEditRequest);
    }


}
