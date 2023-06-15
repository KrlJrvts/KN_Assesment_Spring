package com.example.order_managment_system.business.products;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest implements Serializable {
    private String name;
    private String skuCode;
    private String unitPrice;
}
