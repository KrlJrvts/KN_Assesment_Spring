package com.example.order_managment_system.business.orders.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderByUserResponse {
    private int id;
    private String fullName;
    private List<OrderLineByUserResponse> orderLines;
}
