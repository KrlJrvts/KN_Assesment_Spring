package com.example.order_managment_system.business.orders;

import com.example.order_managment_system.business.orders.dtos.OrderByDateResponse;
import com.example.order_managment_system.business.orders.dtos.OrderCreateRequest;
import com.example.order_managment_system.domain.user.UserService;
import com.example.order_managment_system.domain.user.orderline.OrderLineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
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

        return ordersService.getOrdersBy(date);
    }


    @PostMapping("/create")
    @Operation(summary = "Create a new order",
            description = """by creating first order line with requested userId and submission dateand adding items  by itemId and quantity into the orderline database""")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Order created successfully!"),
            @ApiResponse(responseCode = "403", description = "Order creation failed!")})
    public void createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        ordersService.createOrder(orderCreateRequest);
    }

}
