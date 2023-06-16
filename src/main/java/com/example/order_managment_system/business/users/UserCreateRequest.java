package com.example.order_managment_system.business.users;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest implements Serializable {
    private String registrationCode;
    private String fullName;
    private String email;
    private String telephone;
}
