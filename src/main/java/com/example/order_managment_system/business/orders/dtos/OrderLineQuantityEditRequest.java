package com.example.order_managment_system.business.orders.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineQuantityEditRequest {
    private int orderLineNo;
    private int quantity;
}
