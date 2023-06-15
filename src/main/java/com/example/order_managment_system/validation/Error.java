package com.example.order_managment_system.validation;


import lombok.Getter;

@Getter
public enum Error {
    USER_UNAVAILABLE("User with this email already exists", 111),
    PRODUCT_UNAVAILABLE("Product with this sku code already exists", 112);

    private final String message;
    private  final int errorCode;


    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }



}
