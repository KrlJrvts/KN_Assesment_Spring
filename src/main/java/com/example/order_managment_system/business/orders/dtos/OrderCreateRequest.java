package com.example.order_managment_system.business.orders.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {
    private Integer userId;
    private LocalDate submissionDate;
    private List<OrderLinesCreateRequest> orderLines;
}
