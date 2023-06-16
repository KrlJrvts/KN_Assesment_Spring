package com.example.order_managment_system.validation;


import lombok.Getter;

@Getter
public enum Error {
    USER_UNAVAILABLE("User with this email already exists", 111),
    USER_NOT_FOUND("User with this userId does not exist", 112),
    PRODUCT_UNAVAILABLE("Product with this sku code already exists", 211),
    PRODUCT_NOT_FOUND("Product with this sku code does not exist", 212),
    DATE_INVALID("Date is invalid", 311);

    private final String message;
    private  final int errorCode;


    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }



}
