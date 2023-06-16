package com.example.order_managment_system.validation;

public class ValidationService {

    public static void validateUserEmailIsAvailable(boolean userExists) {
        if (userExists) {
            throw new RuntimeException("User with this email already exists");
        }
    }

    public static void validateUserExists(boolean userExists) {
        if (!userExists) {
            throw new RuntimeException("User with this userId does not exist");
        }
    }


    public static void validateProductSkuCodeIsAvailable(boolean productExists) {
        if (productExists) {
            throw new RuntimeException("Product with this sku code already exists");
        }
    }

    public static void validateProductExists(boolean productExists) {
        if (!productExists) {
            throw new RuntimeException("Product with this sku code does not exist");
        }
    }

    public static void validateDateIsInvalid(boolean dateIsInvalid) {
        if (dateIsInvalid) {
            throw new RuntimeException("Date is invalid");
        }
    }

}

