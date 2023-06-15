package com.example.order_managment_system.business.orders.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderByDateResponse implements Serializable {
    private int id;
    private String fullName;
}
