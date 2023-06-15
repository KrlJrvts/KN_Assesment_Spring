package com.example.order_managment_system.business.orders;

import com.example.order_managment_system.business.orders.dtos.OrderByDateResponse;
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


    @PostMapping("/date")
    @Operation(summary = "Get all orders", description = "Get all orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Orders found successfully!"),
            @ApiResponse(responseCode = "403", description = "Orders not found!")
    })
    public List<OrderByDateResponse> getOrders(@RequestParam LocalDate date) {
        return ordersService.getOrdersBy(date);
    }


}
