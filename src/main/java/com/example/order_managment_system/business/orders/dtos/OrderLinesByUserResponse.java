package com.example.order_managment_system.business.orders.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLinesByUserResponse {
    private int orderId;
    private String productName;
    private int quantity;
    private BigDecimal price;
    private String skuCode;
}
