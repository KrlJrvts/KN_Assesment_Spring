package com.example.order_managment_system.business.orders.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderByProductResponse  implements Serializable {
    private int id;
    private int quantity;
}
