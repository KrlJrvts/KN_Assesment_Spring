package com.example.order_managment_system.business.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;


    @PostMapping("/create")
    @Operation(summary = "Create a new user",
            description = "by registration_code, full_name, email and telephone and check if user already exists by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully!"),
            @ApiResponse(responseCode = "403", description = "User creation failed!")})
    public void addUser(@RequestBody UserCreateRequest userCreateRequest) {

        usersService.createUser(userCreateRequest);
    }


}
